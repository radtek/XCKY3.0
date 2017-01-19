/**
 * SceneInvestigatorMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigator;

/**
 * 现场勘验人信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneInvestigatorMapper extends Mapper<SceneInvestigator> {
	/**
	 * 根据勘验ID查询勘验人信息
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午2:25:54 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneInvestigator> findListByInvestigationId(String investigationId);
	/**
	 * 查询笔录中指挥人员信息包含（姓名、机构、职务）
	 * 方法功能说明：  
	 * 创建：2016-12-21 下午5:23:53 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneInvestigator> findCommandListByInvestigationId(String investigationId);
	/**
	 * 查询笔录中非指挥人员信息包含（姓名、机构、职务）
	 * 方法功能说明：  
	 * 创建：2016-12-21 下午5:51:22 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneInvestigator> findIsNotCommandListByInvestigationId(String investigationId);


}
