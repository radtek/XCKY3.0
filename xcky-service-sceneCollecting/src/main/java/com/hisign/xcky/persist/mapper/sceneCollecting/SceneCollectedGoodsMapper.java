/**
 * SceneCollectedGoodsMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;

/**
 * 现场提取物品信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneCollectedGoodsMapper extends Mapper<SceneCollectedGoods> {
	/**
	 * 根据勘验ID查询提取物品
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:13:27 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneCollectedGoods> findListByInvestigationId(String investigationId);


}
