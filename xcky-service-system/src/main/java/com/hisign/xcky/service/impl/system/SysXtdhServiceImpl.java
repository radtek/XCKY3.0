/**
 * SysXtdhService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.system;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.xcky.api.model.system.SysXtdh;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.SysXtdhService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.system.SysXtdhMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 系统导航信息表Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sysXtdh")
@Consumes({MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sysXtdhService")
@Transactional
public class SysXtdhServiceImpl extends BaseServiceImpl<SysXtdh> implements SysXtdhService {
	
	@Resource
    private SysXtdhMapper sysXtdhMapper;
    
    @Override
	public Mapper<SysXtdh> getMapper() {
		return sysXtdhMapper;
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
    	SysXtdh t = new SysXtdh();
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
    public JsonResult updateById(@HeaderParam("token") String token, SysXtdh t) {
    	super.updateById(t, token);
    	return JsonResultUtil.success(t.getId());
    }
    
    @Override
    @POST
	@Path("photoAdd/{id}")
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    public JsonResult photoAdd(@HeaderParam("token") String token,MultipartFormDataInput input, @PathParam("id") String id) {
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("upLoadFile");
		byte [] bytes=null;
		for (InputPart inputPart : inputParts) {
			try {
				InputStream inputStream = inputPart.getBody(InputStream.class,null);
				bytes = IOUtils.toByteArray(inputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(bytes!=null){
			SysXtdh sysXtdh=new SysXtdh();
			sysXtdh.setId(id);
			sysXtdh.setPhoto(bytes);
			sysXtdhMapper.photoUpdate(sysXtdh);
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
    public JsonResult add(@HeaderParam("token") String token, SysXtdh t) {
    	JsonResult jsonResult=super.add(t, token);
    	SysXtdh sysXtdh=(SysXtdh) jsonResult.getData();
    	return JsonResultUtil.success(sysXtdh.getId());
    }

    /**
     * 批量新增
     * @param list 对象列表
     */
    @Override
    @POST
	@Path("addBatch")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult addBatch(@HeaderParam("token") String token, List<SysXtdh> list) {
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
    public JsonResult queryPage(SysXtdh t) {
    	return super.queryPage(t);
    }
    
}
