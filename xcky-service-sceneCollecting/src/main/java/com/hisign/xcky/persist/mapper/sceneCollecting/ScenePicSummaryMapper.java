/**
 * ScenePicSummaryMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicSummary;

/**
 * 现场相关图片数量汇总Mapper
 *
 * @author MapperGenerator
 */
public interface ScenePicSummaryMapper extends Mapper<ScenePicSummary> {

	public ScenePicSummary findByInvestigationId(String investigationId);

	/**
	 * 统计图片表
	 * 方法功能说明：  
	 * 创建：2016-12-22 下午7:15:54 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public ScenePicSummary totlePictureSum(String investigationId);

}
