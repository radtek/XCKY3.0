/**
 * SceneConditionMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneCondition;

/**
 * 现场条件信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneConditionMapper extends Mapper<SceneCondition> {
	/**
	 * 根据勘验ID查询现场条件
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午2:33:05 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SceneCondition getByInvestigationId(String investigationId);


}
