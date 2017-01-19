/**
 * InputTemplateService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.util.LinkedHashMap;
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

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hisign.xcky.api.model.sceneCollecting.InputTemplate;
import com.hisign.xcky.api.model.system.SysDict;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.InputTemplateService;
import com.hisign.xcky.api.service.system.SysDictService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.InputTemplateMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 信息录入模板Service实现
 *
 * @author ServiceGenerator
 */
@Path("/inputTemplate")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("inputTemplateService")
@Transactional
public class InputTemplateServiceImpl extends BaseServiceImpl<InputTemplate> implements InputTemplateService {
	
	@Resource
    private InputTemplateMapper inputTemplateMapper;
	
	@Resource
	private SysDictService sysDictService;
    
    @Override
	public Mapper<InputTemplate> getMapper() {
		return inputTemplateMapper;
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
		//查找当前模板
		InputTemplate inputTemplate=inputTemplateMapper.getById(id);
		JSONObject jsonObj=JSON.parseObject(inputTemplate.getContent());
		
		//查找标准模板
		InputTemplate baseTemplate=inputTemplateMapper.getByCaseType("AJLBDM");
		String content="";
        LinkedHashMap<String, String> jsonMap = JSON.parseObject(baseTemplate.getContent(), new TypeReference<LinkedHashMap<String, String>>(){});
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
			if(jsonObj.getString(entry.getKey())!=null&&!"".equals(jsonObj.getString(entry.getKey()))){
				content+=jsonObj.getString(entry.getKey())+",";
			}else{
				content+=entry.getValue()+",";
			}
		
        }
		content="["+content.substring(0, content.lastIndexOf(","))+"]";
		inputTemplate.setContent(content);
		return JsonResultUtil.success(inputTemplate);
    }
	
	/**
     * 查询标准模板
     * @param id
     * @return
     */
	@Override
    @POST
	@Path("getBase")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult getBaseTempLate(String caseType) {
		//查找标准模板
		InputTemplate baseTemplate=null;
		if(caseType!=null&&!"".equals(caseType)){
			if("{}".equals(caseType)){
				caseType="AJLBDM";
			}
		}else{
			caseType="AJLBDM";
		}
		if("AJLBDM".equals(caseType)){
			baseTemplate=inputTemplateMapper.getByCaseType(caseType);
		}else{
			List<SysDict> list=sysDictService.findParentByKey(caseType);
			for(SysDict sysDict:list){
				baseTemplate=inputTemplateMapper.getByCaseType(sysDict.getDictKey());
				if(baseTemplate!=null){
					break;
				}
			}
		}
		
		String content="";
        LinkedHashMap<String, String> jsonMap = JSON.parseObject(baseTemplate.getContent(), new TypeReference<LinkedHashMap<String, String>>(){});
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
			content+=entry.getValue()+",";
        }
		
		content="["+content.substring(0, content.lastIndexOf(","))+"]";
		baseTemplate.setContent(content);
		return JsonResultUtil.success(baseTemplate);
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
    	return JsonResultUtil.error("只能逻辑删除");
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
    	InputTemplate t=new InputTemplate();
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
    public JsonResult updateById(@HeaderParam("token") String token, InputTemplate t) {
    	
    	//更改原来的模板id置为effectiveFlag=0;
    	InputTemplate inputTemplate=new InputTemplate();
    	inputTemplate.setId(t.getId());
    	inputTemplate.setEffectiveFlag("0");
    	inputTemplateMapper.updateById(inputTemplate);
    	
    	//新增一条数据
    	t.setId(null);
    	add(token,t);
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
    public JsonResult add(@HeaderParam("token") String token, InputTemplate t) {
    	if(t.getCaseType()!=null && !"".equals(t.getCaseType())){
    		List<InputTemplate> list=inputTemplateMapper.checkExist(t.getCaseType());
    		if(list!=null&&list.size()>0){
    			return JsonResultUtil.error("案件类型重复");
    		}
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<InputTemplate> list) {
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
    public JsonResult queryPage(InputTemplate t) {
    	return super.queryPage(t);
    }
    
}
