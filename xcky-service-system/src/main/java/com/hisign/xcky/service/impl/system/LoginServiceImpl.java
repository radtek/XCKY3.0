package com.hisign.xcky.service.impl.system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.sso.api.constant.UAOPConstant;
import com.hisign.sso.api.entity.sys.LogToken;
import com.hisign.sso.api.entity.sys.MenuResource;
import com.hisign.sso.api.entity.sys.Role;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.sso.api.service.sys.MenuResourceService;
import com.hisign.xcky.api.model.system.SysOnlineLog;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.service.system.LoginService;
import com.hisign.xcky.api.service.system.SysOnlineLogService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 登录登出接口实现类
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2016年11月7日
 */
@Path("/login")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ ContentType.APPLICATION_JSON_UTF_8})
@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private RedisClient  redisClient;
	
	/**
	 * sso登录注销服务
	 */
	@Autowired
	private com.hisign.sso.api.service.sys.LoginService ssoLoginService;
	
	/**
	 * sso角色服务
	 */
	@Autowired
	private com.hisign.sso.api.service.sys.RoleService ssoRoleService;
	
	/**
	 * sso菜单服务
	 */
	@Autowired
	private MenuResourceService menuResourceService;
	
	@Autowired
	private SysOnlineLogService sysOnlineLogService;
	
	@Autowired
	private SysParameterService sysParameterService;
	
	@Override
	@POST
	@Path("login")
	public JsonResult login(@Context HttpServletRequest request,SysUser sysUser) {
		String username = sysUser.getUsername();
		String password = sysUser.getPassword();
		Map<String, Object> data = new HashMap<String, Object>();
		logger.info("用户[{}]登录,时间{}",username,System.currentTimeMillis());
		
		//sso 登录
		com.hisign.sso.api.entity.sys.SysUser ssouser = new com.hisign.sso.api.entity.sys.SysUser();
		ssouser.setAccount(username);
		ssouser.setPass(password);
		LogToken logtoken = ssoLoginService.login("XCKY", ssouser);
		String token=logtoken.getToken();
		ssouser.setUserName(logtoken.getUser().getUserName());
        if(StringUtils.isEmpty(token)){
        	logger.info("SSO:用户[{}]登录服务失败",username);
        	return JsonResultUtil.error("登录失败");
        }
        
        logger.info("SSO:用户[{}]登录成功，token:{}",token);
        ssouser.setUserId(logtoken.getUserId());
        data.put("currentUser", ssouser);
        data.put("token", token);
        sysUser.setId(logtoken.getUserId());
        sysUser.setPassword(logtoken.getUser().getPass());
        
        // 缓存用户信息到redis2个小时
        sysUser.setTrueName(ssouser.getUserName());
        sysUser.setOrganCode(logtoken.getUser().getOrgCode());
        sysUser.setOrganName(logtoken.getUser().getOrgName());
        redisClient.setObj(token, sysUser);
        redisClient.expire(token, Constants.Redis.EXPIRE_TIME, TimeUnit.HOURS);
        
        //保存登录日志
        saveLoginLog(ssouser,request,token);
        
        //ssp 根据用户获取角色
        List<Role> roleList = null;
        try {
        	roleList = ssoRoleService.getRoleListByAccount(username);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("SSO:获取用户[{}]角色列表服务异常",username,e1);
		}
        
        data.put("roles", roleList);
        
        //sso 根据用户获取权限
        Map<String,List<MenuResource>> resMap = new HashMap<String,List<MenuResource>>();
        Map<String,Object> menufilter = new HashMap<String,Object>();
        menufilter.put("systemId", Constants.SYSTEMID);
        menufilter.put("account", username);
        List<MenuResource> menuList = null;
        List<MenuResource> buttonList = null;
        try {
        	//获取登录用户的模块权限
        	menuList = menuResourceService.getMenuTreeByAccount(menufilter);
        	
        	//获取登录用户的按钮权限
            menufilter.put("menuType", UAOPConstant.MenuType.BUTTON);
            buttonList = menuResourceService.getAuthedMenusByAccount(menufilter);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SSO:获取用户[{}]菜单权限服务异常",username,e);
		}
        
        resMap.put("pages", menuList);
        resMap.put("operates", buttonList);
        data.put("limits", resMap);
        
        //初始化系统参数，文件服务器地址
        SysParameter sysParams=sysParameterService.getByKey(Constants.SysParam.FILE_SERVER_PATH);
        Map<String,String> sysParamsMap=new HashMap<String,String>();
        sysParamsMap.put(Constants.SysParam.FILE_SERVER_PATH, sysParams==null?Constants.SysParam.FILE_SERVER_PATH:sysParams.getValue());
        
      //初始化系统参数，文件服务器上传地址
        SysParameter sysParams1=sysParameterService.getByKey(Constants.SysParam.FILE_UPLOAD_PATH);
        sysParamsMap.put(Constants.SysParam.FILE_UPLOAD_PATH, sysParams==null?Constants.SysParam.FILE_UPLOAD_PATH:sysParams1.getValue());
        
        data.put("sysParams",sysParamsMap);
        
        return JsonResultUtil.success(data);
	}
	
	/**
	 * 保存登录日志
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月9日
	 */
	private void saveLoginLog(com.hisign.sso.api.entity.sys.SysUser ssoUser, HttpServletRequest request, String token) {
		SysOnlineLog sysOnlineLog=new SysOnlineLog();
		try {
			sysOnlineLog.setLoginToken(token);
			sysOnlineLog.setLoginUser(ssoUser.getAccount());
			sysOnlineLog.setLoginUserId(ssoUser.getUserId());
			sysOnlineLog.setLoginTime(new Date());
			sysOnlineLog.setLoginUserIp(request.getRemoteAddr());
			sysOnlineLogService.add(token,sysOnlineLog);
		} catch (Exception e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, "服务器异常");
		}
	}

	@Override
	@POST
	@Path("logout")
	public JsonResult logout(@HeaderParam("token") String token) throws Exception {
		SysOnlineLog sysOnlineLog=new SysOnlineLog();
		sysOnlineLog.setLogoutTime(new Date());
		sysOnlineLog.setLoginToken(token);
		sysOnlineLogService.updateByToken(sysOnlineLog);
		redisClient.del(token);
		return JsonResultUtil.success();
	}
	
}
