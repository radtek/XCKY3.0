package com.hisign.xcky.service.impl.system;

import java.util.HashMap;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.sso.api.constant.UAOPConstant;
import com.hisign.sso.api.entity.sys.MenuResource;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.sso.api.service.sys.MenuResourceService;
import com.hisign.xcky.api.model.system.SysLog;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.SysModuleService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 系统模块管理Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sysModule")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sysModuleService")
@Transactional
public class SysModuleServiceImpl  extends BaseServiceImpl<SysLog> implements SysModuleService {

	/**
	 * sso菜单服务
	 */
	@Autowired
	private MenuResourceService menuResourceService;

	@Override
	public Mapper<SysLog> getMapper() {
		return null;
	};
	
	@Override
    @GET
	@Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult getById(@PathParam("id") String id){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("systemId", Constants.SYSTEMID);
		map.put("resourceId", id);
		MenuResource menuResource;
		try {
			menuResource = menuResourceService.getById(map);
			map.put("superId", id);
			map.put("resourceId", "");
			map.put("menuType", UAOPConstant.MenuType.BUTTON);
			List<MenuResource> list=menuResourceService.getChildMenuResources(map);
			menuResource.setChildren(list);
			if(menuResource.getVisibleState()==0){
				menuResource.setVisibleState(1);
			}else{
				menuResource.setVisibleState(0);
			}
		} catch (Exception e) {
			throw new RestBusinessException(Status.OK, "获取模块信息异常");
		}
		return JsonResultUtil.success(menuResource);
    }
	
	
    /**
     * 获取全部模块
     * @return
     * @throws Exception
     */
    @Override
	@POST
	@Path("list")
    public JsonResult list(@HeaderParam("token") String token) throws Exception{
        List<MenuResource> menuList = menuResourceService.getAllOnlyMenusBySystemId(Constants.SYSTEMID);
        return JsonResultUtil.success(menuList.size(),menuList);
    }

    
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(@HeaderParam("token") String token, MenuResource t) {
    	try {
    		if(t.getSuperId()==null||"".equals(t.getSuperId())){
    			t.setSuperId("-1");
    		}
    		t.setSystemId(Constants.SYSTEMID);
    		t.setResourceId(this.generateUUID());
    		t.setIcon("");
    		t.setMenuType(UAOPConstant.MenuType.MENU);
    		if(t.getVisibleState()==0){
    			t.setVisibleState(1);
    		}else{
    			t.setVisibleState(0);
    		}
			menuResourceService.add(t);
			
			if(t.getChildren()!=null&&t.getChildren().size()>0){
				for(MenuResource menuResource:t.getChildren()){
					menuResource.setIcon("");
					menuResource.setMenuType(UAOPConstant.MenuType.BUTTON);
					menuResource.setSuperId(t.getResourceId());
					menuResource.setResourceId(this.generateUUID());
					menuResource.setSystemId(Constants.SYSTEMID);
					menuResourceService.add(menuResource);
				}
			}
			
		} catch (Exception e) {
			throw new RestBusinessException(Status.OK, "添加失败");
		}
    	return JsonResultUtil.success();
    }

    @Override
    @POST
	@Path("del")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult deleteById(@HeaderParam("token") String token, MenuResource menuResource) {
    	try {
    		menuResource.setSystemId(Constants.SYSTEMID);
			menuResourceService.delete(menuResource);
		} catch (Exception e) {
			throw new RestBusinessException(Status.OK, "删除失败");
		}
		return JsonResultUtil.success();
	}

    /**
     * 根据id删除(逻辑删除)
     * @param id
     */
    @Override
    @POST
	@Path("delLogic")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult deleteLogicById(@HeaderParam("token") String token, MenuResource id) {
		return JsonResultUtil.success();
	}

    /**
     * 根据id更新
     * @param t 更新对象
     */
    @Override
    @POST
	@Path("upd")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult updateById(@HeaderParam("token") String token, MenuResource t) {
    	try {
    		t.setIcon("");
    		if(t.getVisibleState()==0){
    			t.setVisibleState(1);
    		}else{
    			t.setVisibleState(0);
    		}
    		t.setSystemId(Constants.SYSTEMID);
			menuResourceService.update(t);
			//先删除下面的子权限，再增加子权限
			if(t.getChildren()!=null&&t.getChildren().size()>0){
				Map<String, Object> map=new HashMap<String,Object>();
				map.put("systemId", Constants.SYSTEMID);
				map.put("superId", t.getResourceId());
				map.put("menuType", UAOPConstant.MenuType.BUTTON);
				menuResourceService.deleteChildrenMenuResources(map);
				
				for(MenuResource menuResource:t.getChildren()){
					menuResource.setIcon("");
					menuResource.setMenuType(UAOPConstant.MenuType.BUTTON);
					menuResource.setSuperId(t.getResourceId());
					menuResource.setResourceId(this.generateUUID());
					menuResource.setSystemId(Constants.SYSTEMID);
					menuResourceService.add(menuResource);
				}
			}
		} catch (Exception e) {
			throw new RestBusinessException(Status.OK, "更新失败");
		}
		return JsonResultUtil.success();
	}




}
