/**
 * SceneCollectedGoodsService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.query;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneQuery.SceneCollectedGoodsPageService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;

import com.hisign.xcky.persist.mapper.query.SceneCollectedGoodsPageMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现场提取物品信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneCollectedGoods")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneCollectedGoodsPageService")
@Transactional
public class SceneCollectedGoodsPageServiceImpl extends BaseServiceImpl<SceneCollectedGoods> implements SceneCollectedGoodsPageService {

	private static final Logger logger = LoggerFactory.getLogger(SceneCollectedGoodsPageServiceImpl.class);

	@Resource
    private SceneCollectedGoodsPageMapper sceneCollectedGoodsMapper;

    @Override
	public Mapper<SceneCollectedGoods> getMapper() {
		return sceneCollectedGoodsMapper;
	}

    /**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryPage(@HeaderParam("token") String token, SceneCollectedGoods t) {
		logger.debug("查询提取物品列表");
		SysUser sysUser = super.getCurrentUser(token);
		if (sysUser == null) {
			throw new RestBusinessException(Response.Status.NOT_FOUND,"查询当前登录用户为空");
		}
		List<Map<String,Object>> resList = null;
		Map<String,Object> map = null;

		//提取现场查询条件
		SceneInvestigation filter = JSONObject.parseObject(JSON.toJSONString(t),SceneInvestigation.class);
		//只查询勘验人、提取人、录入人是自己的现场信息
		filter.setSceneInvestigatorId(sysUser.getId());

		//现场查询
		PageHelper.offsetPage(t.getBegin()-1, t.getEnd()-t.getBegin()+1);
		t.setDeleteFlag(Constants.DELETE_FALSE);
		List<SceneInvestigation> sceneList = sceneCollectedGoodsMapper.queryScene(filter);
		PageInfo<SceneInvestigation> pageInfo = new PageInfo<SceneInvestigation>(sceneList);
		resList = new ArrayList<Map<String,Object>>();
		if (!sceneList.isEmpty()) {
			List<SceneCollectedGoods> _goodsList = null;
			JSONArray jsonArray = null;
			for (SceneInvestigation _scene: sceneList) {
				JSONObject _scenejson = JSON.parseObject(JSON.toJSONString(_scene));
				map = new HashMap<String, Object>();
				jsonArray = new JSONArray();
				//查询该现场的提取物品列表
				t.setInvestigationId(_scene.getId());
				t.setDeleteFlag(Constants.DELETE_FALSE);
				_goodsList = sceneCollectedGoodsMapper.query(t);
				if (_goodsList==null || _goodsList.size() == 0) continue;
				for (SceneCollectedGoods goods : _goodsList) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("collectedGoodsId",goods.getId());
					jsonObject.put("serialNo",goods.getSerialNo());
					jsonObject.put("name",goods.getName());
					jsonObject.put("category",goods.getCategory());
					jsonObject.put("materialEvidenceTypeDict",goods.getMaterialEvidenceTypeDict());
					jsonObject.put("materialEvidenceType",goods.getMaterialEvidenceType());
					jsonObject.put("collectionMethod",goods.getCollectedMethod());
					jsonObject.put("collectionPosition",goods.getCollectedPosition());
					jsonObject.put("collectedPerson",goods.getCollectedPerson());
					jsonObject.put("collectedPersonID",goods.getCollectedPersonID());
					jsonObject.put("storageStatusDict",goods.getStorageStatus());
					jsonObject.put("storageStatus",goods.getStorageStatusCN());
					jsonArray.add(jsonObject);
				}
				map.put("goodsList",jsonArray);
				map.put("rowSpan", _goodsList.size());
				map.put("rowNum", String.valueOf(_scene.getRowNum()));
				map.put("investigationId",_scene.getId());
				map.put("investigationNo",_scene.getInvestigationNo());
				map.put("caseType",_scene.getCaseType());
				map.put("caseRegionalism",_scene.getCaseRegionalism());
				map.put("investigationDateFrom",_scenejson.getString("investigationDateFrom"));
				map.put("investigationDateTo",_scenejson.getString("investigationDateTo"));
				map.put("investigationPlace",_scene.getInvestigationPlace());
				map.put("organName",_scene.getOrganName());
				map.put("sceneInvestigatorId",_scene.getSceneInvestigatorId());
				map.put("sceneInvestigator",_scene.getSceneInvestigator());
				resList.add(map);
			}
		}

		return JsonResultUtil.success(pageInfo.getTotal(),resList);
    }
}
