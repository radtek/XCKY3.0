/**
 * SceneCrimeToolsMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneCrimeTools;

/**
 * 作案工具Mapper
 *
 * @author MapperGenerator
 */
public interface SceneCrimeToolsMapper extends Mapper<SceneCrimeTools> {
	/**
	 * 根据勘验ID查询作案工具
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:46:52 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneCrimeTools> findByInvestigationId(String investigationId);


}
