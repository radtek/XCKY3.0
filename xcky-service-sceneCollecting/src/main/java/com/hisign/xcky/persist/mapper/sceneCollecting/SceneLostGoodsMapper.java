/**
 * SceneLostGoodsMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneLostGoods;

/**
 * 现场损失物品信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneLostGoodsMapper extends Mapper<SceneLostGoods> {
	/**
	 * 根据勘验ID查询损失物品
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:24:07 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneLostGoods> findListByInvestigationId(String investigationId);


}
