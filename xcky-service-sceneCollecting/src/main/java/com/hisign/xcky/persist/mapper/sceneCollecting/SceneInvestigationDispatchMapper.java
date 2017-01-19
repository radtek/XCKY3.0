/**
 * SceneInvestigationDispatchMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationDispatch;

/**
 * 现场接勘信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneInvestigationDispatchMapper extends Mapper<SceneInvestigationDispatch> {
	/**
	 * 根据委托ID查询现场接堪信息
	 * 方法功能说明：  
	 * 创建：2016-12-9 上午11:15:49 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SceneInvestigationDispatch getByInvestigationId(String investigationId);


}
