/**
 * SceneAnalysisSuggestionService.java 
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
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisSuggestion;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.SceneAnalysisSuggestionService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneAnalysisSuggestionMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 现场分析意见Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneAnalysisSuggestion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneAnalysisSuggestionService")
@Transactional
public class SceneAnalysisSuggestionServiceImpl extends BaseServiceImpl<SceneAnalysisSuggestion> implements SceneAnalysisSuggestionService {
	
	@Resource
    private SceneAnalysisSuggestionMapper sceneAnalysisSuggestionMapper;
    
    @Override
	public Mapper<SceneAnalysisSuggestion> getMapper() {
		return sceneAnalysisSuggestionMapper;
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
    	SceneAnalysisSuggestion t = new SceneAnalysisSuggestion();
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
    public JsonResult updateById(@HeaderParam("token") String token, SceneAnalysisSuggestion t) {
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
    public JsonResult add(@HeaderParam("token") String token, SceneAnalysisSuggestion t) {
    	SysUser optUser = super.getCurrentUser(token);
    	t.setAnalysisOrgan(optUser.getOrganCode());
    	t.setAnalysisPerson(optUser.getUsername());
    	t.setAnalysisTime(new Date());
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<SceneAnalysisSuggestion> list) {
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
    public JsonResult queryPage(SceneAnalysisSuggestion t) {
    	return super.queryPage(t);
    }

	@Override
	public SceneAnalysisSuggestion findByInvestigationId(String investigationId) {
		// TODO Auto-generated method stub
		return sceneAnalysisSuggestionMapper.findByInvestigationId(investigationId);
	}

	
    
}
