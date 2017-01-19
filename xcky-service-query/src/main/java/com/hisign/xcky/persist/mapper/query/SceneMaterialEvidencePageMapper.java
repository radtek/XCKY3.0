/**
 * SceneMaterialEvidenceMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.query;

import java.util.List;
import java.util.Map;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneQuery.PageFilter;
import com.hisign.xcky.api.model.sceneQuery.SceneMaterialEvidencePage;
import com.hisign.xcky.api.model.sceneCollecting.SceneMaterialEvidence;

/**
 * 现场痕迹物证列表Mapper
 *
 * @author MapperGenerator
 */
public interface SceneMaterialEvidencePageMapper extends Mapper<SceneMaterialEvidence> {

	public List<SceneMaterialEvidencePage> query(PageFilter t);

	public List<SceneMaterialEvidencePage> queryMaterialEvidenceList(Map<String, String> filterMap);

	
}
