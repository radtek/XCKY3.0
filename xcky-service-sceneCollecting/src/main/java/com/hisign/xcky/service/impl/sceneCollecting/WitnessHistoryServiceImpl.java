/**
 * WitnessHistoryService.java 
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
import com.hisign.xcky.api.model.sceneCollecting.WitnessHistory;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.WitnessHistoryService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.WitnessHistoryMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 历史见证人信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/witnessHistory")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("witnessHistoryService")
@Transactional
public class WitnessHistoryServiceImpl extends BaseServiceImpl<WitnessHistory> implements WitnessHistoryService {
	
	@Resource
    private WitnessHistoryMapper witnessHistoryMapper;
    
    @Override
	public Mapper<WitnessHistory> getMapper() {
		return witnessHistoryMapper;
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
    	WitnessHistory t = new WitnessHistory();
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
    public JsonResult updateById(@HeaderParam("token") String token, WitnessHistory t) {
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
    public JsonResult add(@HeaderParam("token") String token, WitnessHistory t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<WitnessHistory> list) {
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
    public JsonResult queryPage(WitnessHistory t) {
    	return super.queryPage(t);
    }

    /**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("queryAll")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult queryAll(WitnessHistory filter) {
		return JsonResultUtil.success(witnessHistoryMapper.query(filter));
	}
    
}
