/**
 * SceneMaterialEvidenceService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hisign.xcky.api.model.sceneQuery.PageFilter;
import com.hisign.xcky.api.model.sceneQuery.SceneMaterialEvidencePage;
import com.hisign.xcky.api.model.sceneCollecting.SceneMaterialEvidence;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneQuery.SceneMaterialEvidencePageService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.query.SceneMaterialEvidencePageMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 现场痕迹物证信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneMaterialEvidence")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneMaterialEvidencePageService")
@Transactional
public class SceneMaterialEvidencePageServiceImpl extends BaseServiceImpl<SceneMaterialEvidence> implements SceneMaterialEvidencePageService {

	Logger logger = LoggerFactory.getLogger(SceneMaterialEvidencePageServiceImpl.class);

	@Resource
	private SceneMaterialEvidencePageMapper mapper;
	@Override
	public Mapper<SceneMaterialEvidence> getMapper() {
		// TODO Auto-generated method stub
		return mapper;
	}
	
	
	/**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryPage(@HeaderParam("token") String token, PageFilter t) {
		logger.debug("痕迹物证列表查询");
		SysUser sysUser=super.getCurrentUser(token);
    	t.setInvestigatorId(sysUser.getId());

    	
    	//截取最后一个非0的案件类别
    	if(t.getCaseType()!=null&&!"".equals(t.getCaseType())){
    		String caseType=t.getCaseType().replaceAll("0*$","");
    		t.setCaseType(caseType);
    	}
    	//截取最后一个非0的发案区划
    	if(t.getCaseRegionalism()!=null&&!"".equals(t.getCaseRegionalism())){
    		String caseRegionalism=t.getCaseRegionalism().replaceAll("0*$","");
    		t.setCaseRegionalism(caseRegionalism);
    	}
		List<Map<String,Object>> resList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		JSONArray jsonArray = null;

    	//按现场查询出现场分页
    	PageHelper.offsetPage(t.getBegin()-1, t.getEnd()-t.getBegin()+1);
		t.setDeleteFlag(Constants.DELETE_FALSE);
    	List<SceneMaterialEvidencePage> sceneInvestigationlist = mapper.query(t);
		PageInfo<SceneMaterialEvidencePage> pageInfo = new PageInfo<SceneMaterialEvidencePage>(sceneInvestigationlist);

		for(SceneMaterialEvidencePage sceneInvestigation:sceneInvestigationlist){
			map = new HashMap<String, Object>();
			String investigationId = sceneInvestigation.getInvestigationId();
    		Map<String,String> filterMap=new HashMap<String,String>();//查询物证条件
    		filterMap.put("investigationId", investigationId);
    		filterMap.put("storageFlag", t.getStorageFlag());


			jsonArray = new JSONArray();

			List<SceneMaterialEvidencePage> materialEvidenceList = mapper.queryMaterialEvidenceList(filterMap);
    		for(SceneMaterialEvidencePage materialEvidence:materialEvidenceList){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("materialEvidenceId",materialEvidence.getId());
				jsonObject.put("materialEvidenceNo",materialEvidence.getMaterialEvidenceNo());
				jsonObject.put("materialEvidenceName",materialEvidence.getMaterialEvidenceName());
				jsonObject.put("category",materialEvidence.getCategory());
				jsonObject.put("materialEvidenceType",materialEvidence.getMaterialEvidenceType());
				jsonObject.put("leftPosition",materialEvidence.getLeftPosition());
				jsonObject.put("collectionMode",materialEvidence.getCollectionMode());
				jsonObject.put("sceneCollectedPersonID",materialEvidence.getSceneCollectedPersonID());
				jsonObject.put("sceneCollectedPerson",materialEvidence.getSceneCollectedPerson());
    			if("0".equals(materialEvidence.getStorageFlag())){
					jsonObject.put("storageFlag","未送检");
    			}else{
					jsonObject.put("storageFlag","已送检");
    			}
				jsonArray.add(jsonObject);
    		}
			JSONObject _scenejson = JSON.parseObject(JSON.toJSONString(sceneInvestigation));
    		map.put("evidenceList",jsonArray);
			map.put("rowSpan",materialEvidenceList.size());
			map.put("rowNum",sceneInvestigation.getRowNum());
			map.put("investigationId",investigationId);
			map.put("investigationNo",sceneInvestigation.getInvestigationNo());
			map.put("caseType",sceneInvestigation.getCaseType());
			map.put("caseRegionalism",sceneInvestigation.getCaseRegionalism());
			map.put("investigationDateFrom",_scenejson.getString("investigationDateFrom"));
			map.put("investigationDateTo",_scenejson.getString("investigationDateFrom"));
			map.put("investigationPlace",sceneInvestigation.getInvestigationPlace());
			map.put("organName",sceneInvestigation.getOrganName());
			map.put("sceneInvestigatorId",sceneInvestigation.getSceneInvestigatorId());
			map.put("sceneInvestigator",sceneInvestigation.getSceneInvestigator());
			resList.add(map);
		}
		return JsonResultUtil.success(pageInfo.getTotal(), resList);
    }
}
