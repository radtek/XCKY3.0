/**
 * SceneInvestigationStatusService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.util.Date;
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
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationStatus;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationStatusService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneInvestigationStatusMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 现场勘验信息状态Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneInvestigationStatus")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneInvestigationStatusService")
@Transactional
public class SceneInvestigationStatusServiceImpl extends BaseServiceImpl<SceneInvestigationStatus> implements SceneInvestigationStatusService {
	
	@Resource
    private SceneInvestigationStatusMapper sceneInvestigationStatusMapper;
    
    @Override
	public Mapper<SceneInvestigationStatus> getMapper() {
		return sceneInvestigationStatusMapper;
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
    	SceneInvestigationStatus t = new SceneInvestigationStatus();
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
    public JsonResult updateById(@HeaderParam("token") String token, SceneInvestigationStatus t) {
    	return super.updateById(t, token);
    }
    
    /**
     * 更改可修改状态
     * @param list 更新对象数组
     */
    @Override
    @POST
	@Path("updateModify")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult updateByList(@HeaderParam("token") String token, List<SceneInvestigationStatus> list) {
    	if(list!=null&&list.size()>0){
    		for(SceneInvestigationStatus mapList:list){
    			updateByInvestigationId(token,mapList);
    		}
    		return JsonResultUtil.success();
    	}else{
    		return JsonResultUtil.error("参数为空");
    	}
    }

    /**
     * 新增
     * @param t 新增对象
     */
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(@HeaderParam("token") String token, SceneInvestigationStatus t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<SceneInvestigationStatus> list) {
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
    public JsonResult queryPage(SceneInvestigationStatus t) {
    	return super.queryPage(t);
    }


	@Override
	public void updateByInvestigationId(String token,SceneInvestigationStatus sceneInvestigationStatus) {
		SysUser optUser = getCurrentUser(token);

		sceneInvestigationStatus.setVersion(this.generateVersion());
		sceneInvestigationStatus.setUpdateUserId(optUser.getId());
		sceneInvestigationStatus.setUpdateTime(this.getSyetemTime());
		sceneInvestigationStatusMapper.updateByInvestigationId(sceneInvestigationStatus);
	}

	@Override
	public void addOrupdate(String token,SceneInvestigationStatus sceneInvestigationStatus) {
		//根据勘验Id获取信息
		SceneInvestigationStatus obj = sceneInvestigationStatusMapper.findByInvestigationId(sceneInvestigationStatus.getInvestigationId());
		if(obj!=null){
			sceneInvestigationStatus.setId(obj.getId());
			if(sceneInvestigationStatus.getSaveFlag().equals("2")){//提交
				if(obj.getFirstSubmitDatetime()!=null){
					sceneInvestigationStatus.setLastSubmitDatetime(new Date());
				}else{
					sceneInvestigationStatus.setFirstSubmitDatetime(new Date());
					sceneInvestigationStatus.setLastSubmitDatetime(new Date());
				}
			}
			updateById(token,sceneInvestigationStatus);
		}else{
			if(sceneInvestigationStatus.getSaveFlag().equals("2")){//提交
					sceneInvestigationStatus.setFirstSubmitDatetime(new Date());
					sceneInvestigationStatus.setLastSubmitDatetime(new Date());
			}
			add(token,sceneInvestigationStatus);
		}
	}
    
}
