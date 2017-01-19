/**
 * SceneAnalysisSuggestionMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisSuggestion;

/**
 * 现场分析意见Mapper
 *
 * @author MapperGenerator
 */
public interface SceneAnalysisSuggestionMapper extends Mapper<SceneAnalysisSuggestion> {
	/**
	 * 根据勘验ID查询分析意见
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:49:47 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SceneAnalysisSuggestion findByInvestigationId(String investigationId);


}
