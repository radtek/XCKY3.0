/**
 * DictCommService.java 
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
import com.hisign.xcky.api.model.sceneCollecting.DictComm;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.DictCommService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.DictCommMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 常用字典信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/dictComm")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("dictCommService")
@Transactional
public class DictCommServiceImpl extends BaseServiceImpl<DictComm> implements DictCommService {
	
	@Resource
    private DictCommMapper dictCommMapper;
    
    @Override
	public Mapper<DictComm> getMapper() {
		return dictCommMapper;
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
     * 根据id更新
     * @param t 更新对象
     */
    @Override
    @POST
	@Path("upd")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult updateById(@HeaderParam("token") String token, DictComm t) {
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
    public JsonResult add(@HeaderParam("token") String token, DictComm t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<DictComm> list) {
    	//批量新增前，需要先删除所有的
    	if(list!=null&&list.size()>0){
    		DictComm dictComm=list.get(0);
    		SysUser optUser = super.getCurrentUser(token);
    		dictComm.setCreateUserId(optUser.getId());
    		dictCommMapper.deleteBy(dictComm);
    	}
    	
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
    public JsonResult queryPage(DictComm t) {
    	return super.queryPage(t);
    }
	 /**
     * 查询全部
     * @param filter 查询条件对象
     */
	@Override
    @POST
	@Path("queryAll")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult queryAll(@HeaderParam("token") String token, DictComm filter) {
		//获取当前登录用户ID
		SysUser sysUser=this.getCurrentUser(token);
		filter.setCreateUserId(sysUser.getId());
		List<DictComm> reslist=null;
		if(filter.getDictType()!=null && "caseRegionalism".equals(filter.getDictType())){
			reslist = dictCommMapper.queryCaseReg(filter);
		}else{
			reslist = dictCommMapper.query(filter);
		}
		return JsonResultUtil.success(reslist);
	}
    
}
