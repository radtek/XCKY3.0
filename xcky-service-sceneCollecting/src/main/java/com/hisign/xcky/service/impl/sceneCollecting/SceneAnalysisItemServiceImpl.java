/**
 * SceneAnalysisItemService.java 
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
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisItem;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.SceneAnalysisItemService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneAnalysisItemMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 现场分析意见项目Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneAnalysisItem")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneAnalysisItemService")
@Transactional
public class SceneAnalysisItemServiceImpl extends BaseServiceImpl<SceneAnalysisItem> implements SceneAnalysisItemService {
	
	@Resource
    private SceneAnalysisItemMapper sceneAnalysisItemMapper;
    
    @Override
	public Mapper<SceneAnalysisItem> getMapper() {
		return sceneAnalysisItemMapper;
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
    	SceneAnalysisItem t = new SceneAnalysisItem();
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
    public JsonResult updateById(@HeaderParam("token") String token, SceneAnalysisItem t) {
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
    public JsonResult add(@HeaderParam("token") String token, SceneAnalysisItem t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<SceneAnalysisItem> list) {
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
    public JsonResult queryPage(SceneAnalysisItem t) {
    	return super.queryPage(t);
    }

	/**
	 * 根据勘验ID查询分析意见项
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:44:18 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneAnalysisItem> findByInvestigationId(String investigationId) {
		return sceneAnalysisItemMapper.findByInvestigationId(investigationId);
	}

	@Override
	public void deleteByItemType(SceneAnalysisItem sceneAnalysisItem) {
		sceneAnalysisItemMapper.deleteByItemType(sceneAnalysisItem);
	}
    
}
