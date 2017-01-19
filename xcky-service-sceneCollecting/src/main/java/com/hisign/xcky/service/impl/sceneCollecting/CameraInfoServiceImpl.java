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
import com.hisign.xcky.api.model.sceneCollecting.CameraInfo;
import com.hisign.xcky.api.model.sceneCollecting.CommonPicture;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.CameraInfoService;
import com.hisign.xcky.api.service.sceneCollecting.CommonPictureService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.sceneCollecting.CameraInfoMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;
/**
 * 
 * 项目名称：xcky-service-sceneCollecting   
 * 类名称：CameraInfoServiceImpl   
 * 类描述：   摄像头业务接口
 * 创建人：郭辰 
 * 创建时间：2016-12-19 上午10:54:31   
 * 修改人：hisign   
 * 修改时间：2016-12-19 上午10:54:31   
 * 修改备注：   
 * @version
 */
@Path("/cameraInfo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("cameraInfoService")
@Transactional
public class CameraInfoServiceImpl extends BaseServiceImpl<CameraInfo> implements CameraInfoService {
	
	@Resource
    private CameraInfoMapper cameraInfoMapper;
	
	@Autowired
	private CommonPictureService commonPictureService;
	
	@Override
	public Mapper<CameraInfo> getMapper() {
		// TODO Auto-generated method stub
		return cameraInfoMapper;
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
    	CameraInfo t = new CameraInfo();
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
	public JsonResult updateById(@HeaderParam("token") String token, CameraInfo t) {
    	if(StringUtils.isNotEmpty(t.getAttachmentId())){//图片路径不为空
    		if(StringUtils.isNotEmpty(t.getPictureId())){//图片路径不为空
    			CommonPicture commonPicture=new CommonPicture();
            	commonPicture.setCategory(Constants.PICTURE_TYPE.PICTURE_TYPE_XXTTP_I);
            	commonPicture.setFileServerPath(t.getAttachmentId());
            	commonPicture.setInvestigationId(t.getInvestigationId());
            	commonPicture.setId(t.getPictureId());
            	commonPictureService.updateById(token, commonPicture);
        	}else{
        		String pictureId = this.generateUUID();
        		CommonPicture commonPicture=new CommonPicture();
            	commonPicture.setCategory(Constants.PICTURE_TYPE.PICTURE_TYPE_XXTTP_I);
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
	public JsonResult add(@HeaderParam("token") String token, CameraInfo t) {
    	String pictureId=super.generateUUID();
    	CommonPicture commonPicture=new CommonPicture();
    	commonPicture.setCategory(Constants.PICTURE_TYPE.PICTURE_TYPE_XXTTP_I);
    	commonPicture.setId(pictureId);
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
	public JsonResult addBatch(@HeaderParam("token") String token, List<CameraInfo> list) {
    	if (null == list) {
			return JsonResultUtil.error("argument is null");
		}
		for (CameraInfo t : list) {
			this.add(token, t);
		}
		return JsonResultUtil.success();
	}
	@Override
	public List<CameraInfo> findListByInvestigationId(String investigationId) {
		// TODO Auto-generated method stub
		return cameraInfoMapper.findListByInvestigationId(investigationId);
	}

}
