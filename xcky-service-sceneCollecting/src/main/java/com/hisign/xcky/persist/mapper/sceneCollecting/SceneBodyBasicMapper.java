/**
 * SceneBodyBasicMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneBodyBasic;

/**
 * 尸体基本信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneBodyBasicMapper extends Mapper<SceneBodyBasic> {
	/**
	 * 根据勘验ID查询尸体信息
	 * 方法功能说明：  
	 * 创建：2016-12-14 下午2:10:18 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneBodyBasic> findListByInvestigationId(String investigationId);


}
