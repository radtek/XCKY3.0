package com.hisign.xcky.service.impl.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.hisign.sso.api.entity.sys.MenuResource;
import com.hisign.sso.api.entity.sys.Role;
import com.hisign.sso.api.entity.sys.RoleResource;
import com.hisign.sso.api.entity.sys.SysUserRole;
import com.hisign.sso.api.query.QueryCondition;
import com.hisign.sso.api.query.QueryFilter;
import com.hisign.sso.api.rest.entity.sys.User;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.sso.api.service.sys.MenuResourceService;
import com.hisign.sso.api.service.sys.RoleResourceService;
import com.hisign.sso.api.service.sys.RoleService;
import com.hisign.sso.api.service.sys.SysUserRoleService;
import com.hisign.sso.api.service.sys.UserService;
import com.hisign.xcky.api.model.system.SysRole;
import com.hisign.xcky.api.service.system.SysRoleService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.util.JsonResultUtil;

/**  
 * @类功能说明：   系统角色服务实现
 * @作者：hotdog  
 * @创建时间：2016-11-11 下午1:43:07  
 */ 
@Path("/sysRole")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ ContentType.APPLICATION_JSON_UTF_8})
@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl implements
		SysRoleService {

	private final static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);
	
	/**
	 * 非内置角色的TYPE值
	 */
	private final static int UNFIXED_ROLE = 0;
	
	/**
	 * 
	 */
	@Autowired
	private RoleService ssoRoleService;
	
	/**
	 * 
	 */
	@Autowired
	private MenuResourceService menuResourceService;
	 
	/**
	 * sso角色权限关系服务
	 */
	@Autowired
	private RoleResourceService ssoRoleResourceService;
	
	/**
	 * 
	 */
	@Autowired
	private UserService ssoUserService;
	
	/**
	 * 
	 */
	@Autowired
	private SysUserRoleService ssoUserRoleService;
	
	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#findAllRole()
	 */
	@GET
	@Path("roleDict")
	@Override
	public JsonResult findAllRole() throws Exception {
		logger.info("加载角色字典");
		Map<String, Object> filter =  new HashMap<String, Object>();
		filter.put("systemId", Constants.SYSTEMID);
		List<Role> list = ssoRoleService.query(null);
		if (list.isEmpty()) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, "角色字典为空");
		}
		Iterator<Role> it =  list.iterator();
		JSONArray arr = new JSONArray();
		JSONObject jsonObj = null;
		while(it.hasNext()){
			Role role = it.next();
			jsonObj = new JSONObject();
			jsonObj.put("key", role.getRoleId());
			jsonObj.put("value", role.getRoleName());
			arr.add(jsonObj);
		}
		
		return JsonResultUtil.success(arr);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#pagequery(com.hisign.xcky.api.model.system.SysRole)
	 */
	@Override
	@POST
	@Path("pagequery")
	@Consumes({MediaType.APPLICATION_JSON})
	public JsonResult pagequery(SysRole t) throws Exception {
		logger.info("角色分页查询");
    	if (StringUtils.isEmpty(t.getOrderBy())) {
    		t.setOrderBy("createTime");
    	}
    	if (StringUtils.isEmpty(t.getSort())) {
    		t.setSort("desc");
    	}
		QueryFilter queryFilter = JSON.parseObject(JSON.toJSONString(t), QueryFilter.class);
		QueryCondition queryCondition = new QueryCondition();
    	queryCondition.setRoleName(t.getRoleName());
    	queryCondition.setNote(t.getNote());
    	queryCondition.setSystemId(Constants.SYSTEMID);//只查看现勘角色
    	queryFilter.setQueryCondition(queryCondition);
    	
    	queryFilter.setPageByRow(true);
    	queryFilter.setOffset(t.getBegin()-1);
    	queryFilter.setLimit(t.getEnd()-t.getBegin()+1);
    	
		Map<String,Object> map = ssoRoleService.queryByPagination(queryFilter);
		List<SysRole> resList = new ArrayList<SysRole>();
		List<Role> _list = (List<Role>)map.get("result");
		resList = JSON.parseArray(JSON.toJSONString(_list), SysRole.class);
		return JsonResultUtil.success((long) map.get("total"), resList);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#add(com.hisign.xcky.api.model.system.SysRole, java.lang.String)
	 */
	@Override
	@POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult add(SysRole t, String token) throws Exception {
		logger.info("角色新增");
		
		t.setSystemId(Constants.SYSTEMID);
		t.setType(UNFIXED_ROLE);// 非内置角色，可以删除
		Role role = JSON.parseObject(JSON.toJSONString(t),Role.class);
		Map<String, String> retMap = ssoRoleService.add(role);
		t.setRoleId((String)retMap.get("roleId"));
		
		return JsonResultUtil.success(t);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#update(com.hisign.xcky.api.model.system.SysRole, java.lang.String)
	 */
	@Override
	@POST
	@Path("update")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult update(SysRole t, @HeaderParam("token")String token) throws Exception {
		logger.info("角色修改");
		
		t.setSystemId(Constants.SYSTEMID);
		t.setType(UNFIXED_ROLE);// 非内置角色，可以删除
		Role role = JSON.parseObject(JSON.toJSONString(t),Role.class);
		ssoRoleService.update(role);
		return JsonResultUtil.success();
	}

	@Override
	@POST
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult delete(String id) throws Exception {
		logger.info("角色删除");
		if (StringUtils.isEmpty(id)) {
			throw new RestBusinessException(Status.NOT_FOUND, "Parameters cannot be empty");
		}
		ssoRoleService.delete(id);
		return JsonResultUtil.success();
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#view(java.lang.String)
	 */
	@Override
	@GET
	@Path("{roleId}")
	public JsonResult view(@PathParam("roleId") String roleId) throws Exception {
		logger.info("查看角色信息:[{}]", roleId);
		if (StringUtils.isEmpty(roleId)) {
			throw new RestBusinessException(Status.NOT_FOUND, "Parameters cannot be empty");
		}
		Role role = ssoRoleService.getById(roleId);
		return JsonResultUtil.success(role);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#viewPermission(java.lang.String, java.lang.String)
	 */
	@Override
	@POST
	@Path("viewPermis")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult viewPermission(Map<String, String> paramap)
			throws Exception {
		String roleId = paramap.get("roleId");
		String menuId = paramap.get("moduleId");
		
		if (StringUtils.isEmpty(roleId)) {
			throw new RestBusinessException(Status.NOT_FOUND, "Parameter 'roleId' cannot be empty");
		}
		logger.info("获得id为[{}]的角色授权数据", roleId);
		//查看用户信息
		Role role = ssoRoleService.getById(roleId);
		//查看系统下的所有一级菜单
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("systemId", Constants.SYSTEMID);
		map.put("superId", "-1");
		List<MenuResource> firstLevMenuList = menuResourceService.query(map);
		
		if(StringUtil.isEmpty(menuId)){
			menuId =  firstLevMenuList.get(0).getResourceId();
        }
		
		//获得角色所有的权限数据
		map.put("roleId", roleId);
		List<RoleResource> roleResList = ssoRoleResourceService.query(map);//
		
		MenuResource menuResource=new MenuResource();
		menuResource.setResourceId(menuId);
		menuResource.setSystemId(Constants.SYSTEMID);
		List<MenuResource> childrenList=menuResourceService.getChildrenById(menuResource);
		
		Map<String,Object> res = new HashMap<String,Object>();
		res.put("sysRole",role);
		res.put("sysModuleList",firstLevMenuList);
		res.put("moduleList",JSON.toJSON(childrenList));
		res.put("sysRolePermisList",roleResList);
		
		return JsonResultUtil.success(res);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#grantAuthorization(java.util.Map)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@POST
	@Path("authorization")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult grantAuthorization (Map<String, String> paramap) throws Exception {
		String roleId = paramap.get("roleId");
		if (StringUtils.isEmpty(roleId)) {
			throw new RestBusinessException(Status.NOT_FOUND, "Parameter 'roleId' cannot be empty");
		}
		logger.info("为id为[{}]的角色授权", roleId);
		String sysRolePermisIds = paramap.get("sysRolePermisIds");
		
		//删除角色未拥有的权限
		String delRolePermisIds = paramap.get("delRolePermisIds");
		if (delRolePermisIds!=null) {
			List<String> delList = Arrays.asList(delRolePermisIds.split(","));
			RoleResource delres = new RoleResource();
			delres.setSystemId(Constants.SYSTEMID);
			for (int i=0,l=delList.size(); i<l; i++) {
				delres.setResourceId(delList.get(i));
				delres.setRoleId(roleId);
				ssoRoleResourceService.delete(delres);
			}
		}
		
		
		//新增授权
		List<RoleResource> list = new ArrayList<RoleResource>();
		List<String> rolePermisList = Arrays.asList(sysRolePermisIds.split(","));
		if(rolePermisList!=null&&rolePermisList.size()>0){
			Iterator it= rolePermisList.iterator();
			while(it.hasNext()){
				RoleResource res = new RoleResource();
				res.setSystemId(Constants.SYSTEMID);
				res.setRoleId(roleId);
				res.setResourceId((String)it.next());
				res.setResourceType(0); //设置此为菜单权限（这里的权限既包括菜单，也包括按钮，只是sso控制rmi服务访问权限做区分）
				list.add(res);
			}
			ssoRoleResourceService.addBatch(list);
		}
		
		return JsonResultUtil.success();
	}

	@Override
	@GET
	@Path("roleuser/{roleId}")
	public JsonResult viewOwnedUser(@PathParam("roleId")String roleId) throws Exception {
		if (StringUtils.isEmpty(roleId)) {
			throw new RestBusinessException(Status.NOT_FOUND, "Parameter 'roleId' cannot be empty");
		}
		logger.info("为id为[{}]的角色分配用户",roleId);
		Map<String, Object> map = new HashMap<String, Object>();
		//查询该角色下的所有用户
		map.put("systemId", Constants.SYSTEMID);
		map.put("roleId", roleId);
		List<User> associatedUserList = ssoUserService.query(map);
		
		//查询不属于该角色的所有用户
		map.remove("roleId");
		map.put("noRoleId", roleId);
		List<User> allUserList = ssoUserService.query(map);
		
		Role role = ssoRoleService.getById(roleId);
		
		map.clear();
        map.put("sysRole",role);
        map.put("associatedUserList",associatedUserList);
        map.put("allUserList",allUserList);
		return JsonResultUtil.success(map);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysRoleService#roleuserHandle(java.util.Map, java.lang.String)
	 */
	@Override
	@POST
	@Path("userassociation/{option}")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult roleuserHandle(Map<String, String> map,@PathParam("option")String option) throws Exception {
		String roleId=map.get("roleId");
		if (StringUtils.isEmpty(roleId)) {
			throw new RestBusinessException(Status.NOT_FOUND, "Parameters cannot be empty");
		}
		
		SysUserRole userRole = new SysUserRole();
		userRole.setRoleId(roleId);
		String userId = "";
		if ("remove".equals(option)) {
			logger.info("对id为[{}]的角色移除用户", roleId);
			userId = map.get("associatedUserId");
			User ssouser = ssoUserService.getUserByUserId(userId);
			if (ssouser != null && !StringUtils.isEmpty(ssouser.getAccount())) {
				userRole.setAccount(ssouser.getAccount());
				ssoUserRoleService.delete(userRole);
			}
		} else if ("add".equals(option)) {
			userId = map.get("selectUserId");
			logger.info("对id为[{}]的角色添加用户：[{}]", roleId,userId);
			User ssouser = ssoUserService.getUserByUserId(userId);
			if (ssouser != null && !StringUtils.isEmpty(ssouser.getAccount())) {
				userRole.setAccount(ssouser.getAccount());
				ssoUserRoleService.add(userRole);
			}
		} else {
			throw new RestBusinessException(Status.NOT_FOUND, "No execution method");
		}
		
		return JsonResultUtil.success(map);
	}

}
