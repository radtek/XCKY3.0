/**
 * SceneCollectedGoodsPageMapper.java
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.query;

import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.api.persist.Mapper;

import java.util.List;

/**
 * 现场提取物品信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneCollectedGoodsPageMapper extends Mapper<SceneCollectedGoods> {

	/**
	 * 查询提取物品 现场列表
	 * @param scene
	 * @return
	 */
	List<SceneInvestigation> queryScene (SceneInvestigation scene);
}
