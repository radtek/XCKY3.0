/**
 * SysUserService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.hisign.sso.api.constant.UAOPConstant;
import com.hisign.sso.api.entity.sys.Role;
import com.hisign.sso.api.entity.sys.SysUserRole;
import com.hisign.sso.api.entity.sys.UserOrganization;
import com.hisign.sso.api.query.QueryCondition;
import com.hisign.sso.api.query.QueryFilter;
import com.hisign.sso.api.rest.entity.sys.User;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.sso.api.service.sys.RoleService;
import com.hisign.sso.api.service.sys.SysUserRoleService;
import com.hisign.sso.api.service.sys.UserOrganizationService;
import com.hisign.sso.api.service.sys.UserService;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.OrganizationService;
import com.hisign.xcky.api.service.system.SysUserService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.system.SysUserMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.Md5Helper;

/**
 * 系统用户信息Service实现
 *
 * @author ServiceGenerator
 */

@Path("/sysUser")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ ContentType.APPLICATION_JSON_UTF_8})
@Service("sysUserService")
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl implements SysUserService {
	
	private final static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);
	
	@Resource
    private SysUserMapper sysUserMapper;
	
	@Resource
	private OrganizationService organizationService;
	
	/**
	 * sso 用户服务
	 */
	@Autowired
	private UserService ssoUserService;
	
	/**
	 * sso 角色服务
	 */
	@Autowired
	private RoleService ssoRoleService;
	
	/**
	 * sso 用户角色关系服务
	 */
	@Autowired
	private SysUserRoleService ssoUserRoleService;
	
	/**
	 * sso 用户组织机构关系服务
	 */
	@Autowired
	private UserOrganizationService ssoUserOrganizationService;
	
	@Override
	public Mapper getMapper() {
		return sysUserMapper;
	}
	
    /* (non-Javadoc)
     * @see com.hisign.xcky.api.service.system.SysUserService#view(java.lang.String)
     */
    @Override
    @GET
	@Path("{userId}/{type}")
    public JsonResult view(@PathParam("userId") String userId,@PathParam("type") String type) throws Exception{
     	if (StringUtils.isEmpty(userId)) {
    		throw new RestBusinessException(Status.NOT_FOUND, "用户ID为空");
    	}
     	logger.info("查看用户信息[{}]",userId);
		User ssouser = ssoUserService.getUserByUserId(userId);
		SysUser user = JSON.parseObject(JSON.toJSONString(ssouser), SysUser.class);
		if ("view".equals(type)) {
			return JsonResultUtil.success(user);
		} else if ("edit".equals(type)) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("systemId", Constants.SYSTEMID);
			List<Role> roleList = ssoRoleService.query(map);
			map.clear();
			List<String> roleIds = ssoUserRoleService.getRoleIdsByAccount(ssouser.getAccount());
			StringBuffer roleBuffer = new StringBuffer();
			String role = "";
			if (!roleIds.isEmpty()) {
				Iterator<String> it = roleIds.iterator();
				while (it.hasNext()) {
					roleBuffer.append(it.next().toString()).append(",");
				}
				role = roleBuffer.substring(0, roleBuffer.length()-1);
			}
			
			map.put("sysUser", user);
			map.put("roleList", roleList);
			map.put("sysUserRoleIds", role);
			return JsonResultUtil.success(map);
		} else {
			throw new RestBusinessException(Status.NOT_FOUND, "参数为空");
		}
		
    }
    
    /* (non-Javadoc)
     * @see com.hisign.xcky.api.service.system.SysUserService#add(com.hisign.xcky.api.model.system.SysUser, java.lang.String)
     */
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(SysUser t, @HeaderParam("token") String token) throws Exception {
    	SysUser optUser = getCurrentUser(token);
    	if (optUser == null) {
    		throw new RestBusinessException(Status.NOT_FOUND,"查询当前登录用户为空");
    	}
    	logger.info("用户新增");

    	User ssouser = JSON.parseObject(JSON.toJSONString(t), User.class);
    	ssouser.setUserType(UAOPConstant.UserType.XCKY); //用户类型 现勘用户
    	ssouser = ssoUserService.add(ssouser);
    	t.setId(ssouser.getUserId());
    	
    	return JsonResultUtil.success(t);
    }
    
    /* (non-Javadoc)
     * @see com.hisign.xcky.api.service.system.SysUserService#update(com.hisign.xcky.api.model.system.SysUser, java.lang.String)
     */
    @Override
    @POST
	@Path("update")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult update(SysUser sysuser, @HeaderParam("token")String token) throws Exception {
    	SysUser optUser = getCurrentUser(token);
    	if (optUser == null) {
    		throw new RestBusinessException(Status.NOT_FOUND,"查询当前登录用户为空");
    	}
    	logger.info("用户[{}]修改",sysuser.getUsername());
    	if (StringUtils.isNotEmpty(sysuser.getNewPassword())) {
    		sysuser.setPassword(Md5Helper.getMD5(sysuser.getNewPassword()));
        }
    	User ssouser = JSON.parseObject(JSON.toJSONString(sysuser), User.class);
    	ssoUserService.update(ssouser);
    	//更新角色关系
    	List<String> userIds = Arrays.asList(sysuser.getId());
    	List<SysUserRole> userRoleList = new ArrayList<SysUserRole>();
    	ssoUserRoleService.deleteByUserIds(userIds);
    	String roleIds = sysuser.getRoleIds();
    	if (!StringUtils.isEmpty(roleIds)) {
    		String[] roleArr = roleIds.split(",");
    		for (int i=0,l=roleArr.length; i<l; i++) {
    			SysUserRole sysUserRole = new SysUserRole();
    			sysUserRole.setAccount(sysuser.getUsername());
    			sysUserRole.setRoleId(roleArr[i]);
    			userRoleList.add(sysUserRole);
    		}
    		ssoUserRoleService.addBatch(userRoleList);
    	}
    	
    	//更新用户单位关系
    	UserOrganization userOrganization = new UserOrganization();
    	userOrganization.setUserId(sysuser.getId());
    	userOrganization.setOrgId(sysuser.getOrganId());
		userOrganization.setType(0);
		userOrganization.setAdmin(0);
		
		ssoUserOrganizationService.deleteByUserIds(userIds);
		ssoUserOrganizationService.add(userOrganization);
		
    	return JsonResultUtil.success();
    }
    
    @Override
    @POST
    @Path("deleteLogic")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult deleteLogic(SysUser sysuser, @HeaderParam("token")String token) throws Exception {
    	return JsonResultUtil.success();
    }
    
    
    /* (non-Javadoc)
     * @see com.hisign.xcky.api.service.system.SysUserService#deleteByUserIds(java.lang.String)
     */
    @Override
    @POST
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult deleteByUserIds (String userIds) throws Exception{
    	logger.info("用户[{}]删除",userIds);
    	if (StringUtils.isEmpty(userIds)) {
    		throw new RestBusinessException(Status.NOT_FOUND,"args are null");
    	}
    	List<String> ids = Arrays.asList(userIds.split(","));
    	ssoUserService.deleteByUserIds(ids);
    	return JsonResultUtil.success();
    }
    
    /* (non-Javadoc)
     * @see com.hisign.xcky.api.service.system.SysUserService#pageQuery(com.hisign.xcky.api.model.system.SysUser)
     */
    @Override
    @POST
    @Path("pagequery")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult pagequery (SysUser sysUser) throws Exception {
    	logger.info("用户分页查询");
    	sysUser.setDeleteFlag(Constants.DELETE_FALSE);
    	if (StringUtils.isEmpty(sysUser.getOrderBy())) {
    		sysUser.setOrderBy("createTime");
    	}
    	if (StringUtils.isEmpty(sysUser.getSort())) {
    		sysUser.setSort("desc");
    	}
    	
    	List<SysUser> resList = new ArrayList<SysUser>();
    	QueryFilter queryFilter = JSON.parseObject(JSON.toJSONString(sysUser), QueryFilter.class);
    	QueryCondition queryCondition = new QueryCondition();
    	queryCondition.setAccount(sysUser.getUsername());
    	queryCondition.setUserName(sysUser.getTrueName());
    	queryCondition.setRoleName(sysUser.getRoleName());
    	//queryCondition.setSystemId(Constants.SYSTEMID);//只查看现勘用户
    	queryFilter.setQueryCondition(queryCondition);
    	
    	queryFilter.setPageByRow(true);
    	queryFilter.setOffset(sysUser.getBegin()-1);
    	queryFilter.setLimit(sysUser.getEnd()-sysUser.getBegin()+1);
    	
    	Map<String,Object> map = ssoUserService.queryByPagination(queryFilter);
    	List<User> _list = (List<User>)map.get("users");
    	resList = JSON.parseArray(JSON.toJSONString(_list), SysUser.class);
    	return JsonResultUtil.success((long) map.get("total"), resList);
    }
    
    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
    @POST
	@Path("get")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult getById(String id) {
		return super.getById(id);
    }
	
    /**
     * 根据id更新
     * @param t 更新对象
     */
    @SuppressWarnings("unchecked")
	@Override
    @POST
	@Path("upd")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult updateById(@HeaderParam("token") String token, SysUser t) {
    	SysUser sysUser=(SysUser) super.getById(t.getId()).getData();
    	SysUser optUser = getCurrentUser(token);
    	t.setUsername(optUser.getUsername());
    	t.setPassword(optUser.getPassword());
    	t.setUserLevel("1");
    	if(sysUser==null){
    		super.add(t, token);
    	}else{
    		super.updateById(t, token);
    	}
    	return JsonResultUtil.success();
    }
    
    
    @Override
    @POST
    @Path("queryTreeUser")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryTreeUser (@HeaderParam("token") String token, SysUser sysUser){
    	List<SysUser> userList=sysUserMapper.queryTree(sysUser);
    	return JsonResultUtil.success(userList);
    }
    
    @Override
    @POST
    @Path("queryAll")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryAll (@HeaderParam("token") String token, SysUser sysUser){
    	List<SysUser> userList=sysUserMapper.query(sysUser);
    	return JsonResultUtil.success(userList);
    }
    

}
