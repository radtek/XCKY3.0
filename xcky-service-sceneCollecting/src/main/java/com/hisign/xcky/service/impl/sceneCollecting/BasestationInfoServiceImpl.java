/**
 * BasestationInfoService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hisign.xcky.api.model.sceneCollecting.BasestationInfo;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.BasestationInfoService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.sceneCollecting.BasestationInfoMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 基站信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/basestationInfo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("basestationInfoService")
@Transactional
public class BasestationInfoServiceImpl extends BaseServiceImpl<BasestationInfo> implements BasestationInfoService {
	
	@Resource
    private BasestationInfoMapper basestationInfoMapper;
    
    @Override
	public Mapper<BasestationInfo> getMapper() {
		return basestationInfoMapper;
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
    @GET
	@Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult getById(@PathParam("id")String id) {
		return super.getById(id);
    }

    /**
     * 根据id删除(物理删除)
     * @param id
     */
    @Override
    @POST
	@Path("del")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult deleteById(@HeaderParam("token") String token, String id) {
    	if(StringUtils.isNotEmpty(id)){
    		return super.deleteById(id);
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
    public JsonResult deleteLogicById(@HeaderParam("token") String token, String id) {
    	BasestationInfo t = new BasestationInfo();
    	t.setId(id);
    	if(StringUtils.isNotEmpty(id)){
    		return super.deleteLogicById(t, token);
    	}
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
    public JsonResult updateById(@HeaderParam("token") String token, BasestationInfo t) {
    	return super.updateById(t, token);
    }

    /**
     * 新增
     * @param t 新增对象
     */
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(@HeaderParam("token") String token, BasestationInfo t) {
    	return super.add(t, token);
    }

    /**
     * 批量新增
     * @param list 对象列表
     */
    @Override
    @POST
	@Path("addBatch")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult addBatch(@HeaderParam("token") String token, List<BasestationInfo> list) {
    	return super.addBatch(list, token);
    }

    /**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryPage(BasestationInfo t) {
    	return super.queryPage(t);
    }
    
    /**
     * 查询基站信息
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("queryAll")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryAll(BasestationInfo t) {
    	List<BasestationInfo> list=basestationInfoMapper.queryAll(t);
    	if(t.getFileName()!=null&&"data.xml".equals(t.getFileName().toLowerCase())){
    		String tempBsType="";
    		List<BasestationInfo> tempList=null;
    		//Map<String,List<BasestationInfo>> map=new LinkedHashMap<String,List<BasestationInfo>>();
    		JSONObject jsonObj=new JSONObject();
    		JSONArray  jsonArr=new JSONArray();
    		if(list!=null&&list.size()>0){
    			for(BasestationInfo baseStationInfo: list){
    				if(!tempBsType.equals(baseStationInfo.getBsType())){
    					if(tempList!=null&&tempList.size()>0){
    						//map.put(tempBsType, tempList);
    						jsonObj.put("name", tempBsType);
    						jsonObj.put("list", tempList);
    						jsonArr.add(jsonObj);
    					}
    					tempList=new ArrayList<BasestationInfo>();
    					jsonObj=new JSONObject();
    					tempBsType=baseStationInfo.getBsType();
    				}
    				tempList.add(baseStationInfo);
    			}
    			//map.put(tempBsType, tempList);
    			jsonObj.put("name", tempBsType);
				jsonObj.put("list", tempList);
				jsonArr.add(jsonObj);
    			return JsonResultUtil.success(jsonArr);
    		}
    	}
    	return JsonResultUtil.success(list);
    }    

	@Override
	public void deleteAllLogicById(String token, String investigationId) {
		SysUser optUser = getCurrentUser(token);
		BasestationInfo t=new BasestationInfo();
		t.setInvestigationId(investigationId);
		t.setVersion(this.generateVersion());
		t.setUpdateUserId(optUser.getId());
		t.setUpdateTime(this.getSyetemTime());
		t.setDeleteFlag(Constants.DELETE_TRUE);
		basestationInfoMapper.deleteAllLogicById(t);
	}
    
}
