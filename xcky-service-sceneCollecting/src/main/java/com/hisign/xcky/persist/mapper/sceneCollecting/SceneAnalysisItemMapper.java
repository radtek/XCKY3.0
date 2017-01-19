/**
 * SceneAnalysisItemMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisItem;

/**
 * 现场分析意见项目Mapper
 *
 * @author MapperGenerator
 */
public interface SceneAnalysisItemMapper extends Mapper<SceneAnalysisItem> {
	/**
	 * 根据勘验ID查询集合
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:44:40 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneAnalysisItem> findByInvestigationId(String investigationId);

	/**
	 * 根据勘验id和itemType进行删除
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月12日
	 */
	public void deleteByItemType(SceneAnalysisItem sceneAnalysisItem);


}
