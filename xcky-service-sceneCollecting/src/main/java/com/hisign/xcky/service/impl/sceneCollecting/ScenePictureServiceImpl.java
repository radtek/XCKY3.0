/**
 * ScenePictureService.java 
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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.xcky.api.model.sceneCollecting.CommonPicture;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicture;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.CommonPictureService;
import com.hisign.xcky.api.service.sceneCollecting.ScenePictureService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.ScenePictureMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 现场图、现场照片信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/scenePicture")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("scenePictureService")
@Transactional
public class ScenePictureServiceImpl extends BaseServiceImpl<ScenePicture> implements ScenePictureService {
	
	@Resource
    private ScenePictureMapper scenePictureMapper;
	
	@Autowired
	private CommonPictureService commonPictureService;
    
    @Override
	public Mapper<ScenePicture> getMapper() {
		return scenePictureMapper;
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
    	ScenePicture t = new ScenePicture();
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
    public JsonResult updateById(@HeaderParam("token") String token, ScenePicture t) {
    	if(StringUtils.isNotEmpty(t.getAttachmentId())){//图片路径不为空
    		if(StringUtils.isNotEmpty(t.getPictureId())){//图片路径不为空
    			CommonPicture commonPicture=new CommonPicture();
            	commonPicture.setCategory(t.getCategory());
            	commonPicture.setFileServerPath(t.getAttachmentId());
            	commonPicture.setInvestigationId(t.getInvestigationId());
            	commonPicture.setId(t.getPictureId());
            	commonPictureService.updateById(token, commonPicture);
        	}else{
        		String pictureId = this.generateUUID();
        		CommonPicture commonPicture=new CommonPicture();
            	commonPicture.setCategory(t.getCategory());
            	commonPicture.setId(pictureId);
            	commonPicture.setFileServerPath(t.getAttachmentId());
            	commonPicture.setInvestigationId(t.getInvestigationId());
            	commonPictureService.add(token, commonPicture);
        		t.setPictureId(pictureId);
        	}
    	}
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
    public JsonResult add(@HeaderParam("token") String token, ScenePicture t) {
    	String pictureId=super.generateUUID();
    	CommonPicture commonPicture=new CommonPicture();
    	commonPicture.setId(pictureId);
    	commonPicture.setCategory(t.getCategory());
    	commonPicture.setFileServerPath(t.getAttachmentId());
    	commonPicture.setInvestigationId(t.getInvestigationId());
    	commonPictureService.add(token, commonPicture);
    	t.setPictureId(pictureId);
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<ScenePicture> list) {
    	if (null == list) {
			return JsonResultUtil.error("argument is null");
		}
		for (ScenePicture t : list) {
			this.add(token, t);
		}
		return JsonResultUtil.success();
    }

    /**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryPage(ScenePicture t) {
    	return super.queryPage(t);
    }

	@Override
	public List<ScenePicture> findListByInvestigationIdAndCategory(String investigationId, String category) {
		// TODO Auto-generated method stub
		ScenePicture filter = new ScenePicture();
		filter.setInvestigationId(investigationId);
		filter.setCategory(category);
		return scenePictureMapper.findListByFilter(filter);
	}
    
}
