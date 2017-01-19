/**
 * SceneInvestigationStatusMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationStatus;

/**
 * 现场勘验信息状态Mapper
 *
 * @author MapperGenerator
 */
public interface SceneInvestigationStatusMapper extends Mapper<SceneInvestigationStatus> {
	/**
	 * 根据勘验ID修改
	 * 方法功能说明：  
	 * 创建：2016-12-23 下午2:16:58 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void updateByInvestigationId(SceneInvestigationStatus sceneInvestigationStatus);
	/**
	 * 根据勘验ID查询
	 * 方法功能说明：  
	 * 创建：2016-12-23 下午2:32:23 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SceneInvestigationStatus findByInvestigationId(String investigationId);


}
