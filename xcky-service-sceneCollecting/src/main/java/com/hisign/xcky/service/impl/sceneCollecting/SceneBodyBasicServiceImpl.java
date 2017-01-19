/**
 * SceneBodyBasicService.java 
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.xcky.api.model.sceneCollecting.CommonAttachment;
import com.hisign.xcky.api.model.sceneCollecting.SceneBodyBasic;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.CommonAttachmentService;
import com.hisign.xcky.api.service.sceneCollecting.SceneBodyBasicService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneBodyBasicMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 尸体基本信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneBodyBasic")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneBodyBasicService")
@Transactional
public class SceneBodyBasicServiceImpl extends BaseServiceImpl<SceneBodyBasic> implements SceneBodyBasicService {
	
	@Resource
    private SceneBodyBasicMapper sceneBodyBasicMapper;
	
	@Resource
	private CommonAttachmentService commonAttachmentService;
    
    @Override
	public Mapper<SceneBodyBasic> getMapper() {
		return sceneBodyBasicMapper;
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
    	SceneBodyBasic t = new SceneBodyBasic();
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
    public JsonResult updateById(@HeaderParam("token") String token, SceneBodyBasic t) {
    	if( t.getReportid()!=null&& !"".equals(t.getReportid())&& 
    			t.getReportAttachmentId()!=null && !"".equals(t.getReportAttachmentId())){
    		CommonAttachment commonAttachment=new CommonAttachment();
    		commonAttachment.setId(t.getReportid());
    		commonAttachment.setFileServerPath(t.getReportAttachmentId());
    		commonAttachmentService.updateById(token, commonAttachment);
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
    public JsonResult add(@HeaderParam("token") String token, SceneBodyBasic t) {
    	if(t.getReportAttachmentId()!=null&& !"".equals(t.getReportAttachmentId())){
    		String reportId=super.generateUUID();
    		CommonAttachment commonAttachment=new CommonAttachment();
    		commonAttachment.setId(reportId);
    		commonAttachment.setInvestigationId(t.getInvestigationId());
    		commonAttachment.setCategory("04");
    		commonAttachment.setFileServerPath(t.getReportAttachmentId());
    		commonAttachmentService.add(token, commonAttachment);
    		t.setReportid(reportId);
    	}
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<SceneBodyBasic> list) {
    	
    	if(list!=null&&list.size()>0){
    		for (SceneBodyBasic t : list) {
    			this.add(token, t);
    		}
    	}else{
    		return JsonResultUtil.error("数据为空!");
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
    public JsonResult queryPage(SceneBodyBasic t) {
    	return super.queryPage(t);
    }

	@Override
	public List<SceneBodyBasic> findByInvestigationId(String investigationId) {
		// TODO Auto-generated method stub
		return sceneBodyBasicMapper.findListByInvestigationId(investigationId);
	}
    
}
