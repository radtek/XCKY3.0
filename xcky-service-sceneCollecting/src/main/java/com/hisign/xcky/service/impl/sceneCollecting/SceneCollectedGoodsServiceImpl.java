/**
 * SceneCollectedGoodsService.java 
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.xcky.api.model.sceneCollecting.CommonPicture;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedPerson;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.CommonPictureService;
import com.hisign.xcky.api.service.sceneCollecting.SceneCollectedGoodsService;
import com.hisign.xcky.api.service.system.SysSequenceService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneCollectedGoodsMapper;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneCollectedPersonMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 现场提取物品信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneCollectedGoods")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneCollectedGoodsService")
@Transactional
public class SceneCollectedGoodsServiceImpl extends BaseServiceImpl<SceneCollectedGoods> implements SceneCollectedGoodsService {

	private static final Logger logger = LoggerFactory.getLogger(SceneCollectedGoodsServiceImpl.class);

	@Resource
    private SceneCollectedGoodsMapper sceneCollectedGoodsMapper;
	
	@Autowired
	private CommonPictureService commonPictureService;

	/**
	 * 流水业务接口
	 */
	@Autowired
	private SysSequenceService sysSequenceService;
    
    @Override
	public Mapper<SceneCollectedGoods> getMapper() {
		return sceneCollectedGoodsMapper;
	}
    @Autowired
    private SceneCollectedPersonMapper sceneCollectedPersonMapper;
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
    	SceneCollectedGoods t = new SceneCollectedGoods();
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
    public JsonResult updateById(@HeaderParam("token") String token, SceneCollectedGoods t) {
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
            	commonPicture.setId(pictureId);
            	commonPicture.setCategory(t.getCategory());
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
    public JsonResult add(@HeaderParam("token") String token, SceneCollectedGoods t) {
    	String pictureId=super.generateUUID();
    	CommonPicture commonPicture=new CommonPicture();
    	commonPicture.setId(pictureId);
    	commonPicture.setCategory(Constants.PICTURE_TYPE.PICTURE_TYPE_TQWPZP_I);
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<SceneCollectedGoods> list) {
		if (null == list) {
			return JsonResultUtil.error("argument is null");
		}
		for (SceneCollectedGoods t : list) {
			this.add(token, t);
		}
		return JsonResultUtil.success();
    }

	/**
	 * 根据勘验ID查询提取物
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:12:46 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneCollectedGoods> findListByInvestigationId(String investigationId) {
		// TODO Auto-generated method stub
		List<SceneCollectedGoods> list = sceneCollectedGoodsMapper.findListByInvestigationId(investigationId);
		if(list!=null&&list.size()>0){
			for(SceneCollectedGoods obj:list){
				List<SceneCollectedPerson> sceneCollectedPersonList = sceneCollectedPersonMapper.findListByMaterialEvidenceId(obj.getId());
			    obj.setSceneCollectedPerson(sceneCollectedPersonList);
			}
		}
		return list;
	}
	/**
	 * 更新数据对象
	 * 方法功能说明：  
	 * 创建：2016-12-14 下午6:08:17 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	@Override
	public void updateByObj(String token, SceneCollectedGoods obj) {
		SceneCollectedGoods sceneCollectedGoods =sceneCollectedGoodsMapper.getById(obj.getId());
		if(sceneCollectedGoods!=null){
			updateById(token,obj);
		}else{
			add(obj, token);
		}
	}
    
}
