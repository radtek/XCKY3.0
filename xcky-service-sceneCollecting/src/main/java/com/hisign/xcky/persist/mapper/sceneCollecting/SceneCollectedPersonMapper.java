/**
 * SceneCollectedPersonMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedPerson;

/**
 * 物品、物证提取人信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneCollectedPersonMapper extends Mapper<SceneCollectedPerson> {
	/**
	 * 根据痕迹物证ID查询收集人
	 * 方法功能说明：  
	 * 创建：2016-12-19 下午2:17:34 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneCollectedPerson> findListByMaterialEvidenceId(String id);
	/**
	 * 根据勘验删除
	 * 方法功能说明：  
	 * 创建：2017-1-4 下午2:07:54 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void deleteByinvestigationId(String investigationId);


}
