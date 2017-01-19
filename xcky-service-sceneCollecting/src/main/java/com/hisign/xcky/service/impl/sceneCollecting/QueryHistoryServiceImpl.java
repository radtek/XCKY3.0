/**
 * QueryHistoryService.java 
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
import com.hisign.xcky.api.model.sceneCollecting.QueryHistory;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.QueryHistoryService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.QueryHistoryMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.StringUtils;

/**
 * 历史查询条件Service实现
 *
 * @author ServiceGenerator
 */
@Path("/queryHistory")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("queryHistoryService")
@Transactional
public class QueryHistoryServiceImpl extends BaseServiceImpl<QueryHistory> implements QueryHistoryService {
	
	@Resource
    private QueryHistoryMapper queryHistoryMapper;
    
    @Override
	public Mapper<QueryHistory> getMapper() {
		return queryHistoryMapper;
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
    	if(org.apache.commons.lang.StringUtils.isNotEmpty(id)){
    		return super.deleteById(id);
    	}
    	return JsonResultUtil.success();
    }

    /**
     * 新增
     * @param t 新增对象
     */
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(@HeaderParam("token") String token, QueryHistory t) {
    	String queryType=t.getQueryType();
    	if(StringUtils.isNull(queryType)){
    		return JsonResultUtil.error("条件类型为空");
    	}
    	return super.add(t, token);
    }

    

    /**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryList(@HeaderParam("token") String token,QueryHistory t) {
    	SysUser optUser = getCurrentUser(token);
    	t.setCreateUserId(optUser.getId());
    	t.setDeleteFlag("0");
    	List<QueryHistory> list=queryHistoryMapper.query(t);
    	return JsonResultUtil.success(list);
    }
    
}
