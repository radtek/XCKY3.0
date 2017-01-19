/**
 * TextTemplateService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.util.HashMap;
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

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hisign.xcky.api.model.sceneCollecting.InputTemplate;
import com.hisign.xcky.api.model.sceneCollecting.TextTemplate;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.TextTemplateService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.InputTemplateMapper;
import com.hisign.xcky.persist.mapper.sceneCollecting.TextTemplateMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 文本信息模板Service实现
 *
 * @author ServiceGenerator
 */
@Path("/textTemplate")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("textTemplateService")
@Transactional
public class TextTemplateServiceImpl extends BaseServiceImpl<TextTemplate> implements TextTemplateService {
	
	@Resource
    private TextTemplateMapper textTemplateMapper;
	
	@Resource
    private InputTemplateMapper inputTemplateMapper;
    
    @Override
	public Mapper<TextTemplate> getMapper() {
		return textTemplateMapper;
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
		TextTemplate textTemplate=textTemplateMapper.getById(id);
		InputTemplate inputTemplate=null;
		//如果不是通用的
		if("0".equals(textTemplate.getCommonFlag())){
			inputTemplate=inputTemplateMapper.getByCaseType(textTemplate.getCaseType());
			if(inputTemplate==null){
				inputTemplate=inputTemplateMapper.getByCaseType("AJLBDM");
			}
		}else{
			//查找标准模板
			inputTemplate=inputTemplateMapper.getByCaseType("AJLBDM");
		}
		JSONObject baseJson=JSON.parseObject(inputTemplate.getContent());
		String content="";
		for(String key:baseJson.keySet()){
			content+=baseJson.getString(key)+",";
		}
		content="["+content.substring(0, content.lastIndexOf(","))+"]";
		inputTemplate.setContent(content);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("textTemplate", textTemplate);
		map.put("inputTemplate", inputTemplate);
		return JsonResultUtil.success(map);
    }
	
	@Override
    @POST
	@Path("getAllByType")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult getAllByType(TextTemplate t){
		return JsonResultUtil.success(textTemplateMapper.getAllByType(t));
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
    	TextTemplate t = new TextTemplate();
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
    public JsonResult updateById(@HeaderParam("token") String token, TextTemplate t) {
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
    public JsonResult add(@HeaderParam("token") String token, TextTemplate t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<TextTemplate> list) {
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
    public JsonResult queryPage(TextTemplate t) {
    	return super.queryPage(t);
    }
    
    /**
     * 新增时候查询模板
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("queryListBy")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryListBy(TextTemplate t) {
    	if(t.getCaseType()==null||"".equals(t.getCaseType())){
    		t.setCaseType("AJLBDM");
    	}
    	t.setDeleteFlag("0");
    	List<TextTemplate> list=textTemplateMapper.query(t);
    	return JsonResultUtil.success(list);
    }
    
    
    
}
