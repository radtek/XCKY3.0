/**
 * ScenePicSummaryService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicSummary;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.ScenePicSummaryService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.ScenePicSummaryMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;

/**
 * 现场相关图片数量汇总Service实现
 *
 * @author ServiceGenerator
 */
@Path("/scenePicSummary")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("scenePicSummaryService")
@Transactional
public class ScenePicSummaryServiceImpl extends BaseServiceImpl<ScenePicSummary> implements ScenePicSummaryService {
	
	@Resource
    private ScenePicSummaryMapper scenePicSummaryMapper;
    
    @Override
	public Mapper<ScenePicSummary> getMapper() {
		return scenePicSummaryMapper;
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
    	return super.deleteById(id);
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
    	ScenePicSummary t = new ScenePicSummary();
    	t.setId(id);
    	return super.deleteLogicById(t, token);
    }

    /**
     * 根据id更新
     * @param t 更新对象
     */
    @Override
    @POST
	@Path("upd")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult updateById(@HeaderParam("token") String token, ScenePicSummary t) {
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
    public JsonResult add(@HeaderParam("token") String token, ScenePicSummary t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<ScenePicSummary> list) {
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
    public JsonResult queryPage(ScenePicSummary t) {
    	return super.queryPage(t);
    }

	@Override
	public ScenePicSummary findByInvestigationId(String id) {
		// TODO Auto-generated method stub
		return scenePicSummaryMapper.findByInvestigationId(id);
	}

	@Override
	public void updateByInvestigationId(String token,String id) {
		//删除旧数据
		scenePicSummaryMapper.deleteById(id);
		//查询统计结果
		ScenePicSummary t = scenePicSummaryMapper.totlePictureSum(id);
		//插入新的统计结果
		if(t==null){
			t= new ScenePicSummary();
			t.setInvestigationId(id);
			t.setFocusPartPicAmount(0);
			t.setProfilePictureAmount(0);
			t.setDetailPictureAmount(0);
			t.setScenePhotoAmount(0);
			t.setOrientationMapAmount(0);
			t.setPlaneGraphAmount(0);
			t.setScenePictureAmount(0);
			t.setOtherEvidenceAmount(0);
			t.setVideoEvidenceAmount(0);
			t.setElectroEvidenceAmount(0);
			t.setFileEvidenceAmount(0);
			t.setPhysicalEvidenceAmount(0);
			t.setToxicEvidenceAmount(0);
			t.setBioEvidenceAmount(0);
			t.setSpecialprintAmount(0);
			t.setBulletprintAmount(0);
			t.setToolmarkAmount(0);
			t.setFootprintAmount(0);
			t.setHandprintAmount(0);
		}
		super.add(t, token);
	}
}
