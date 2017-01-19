/**
 * SceneInvestigationMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 现场勘验信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneInvestigationMapper extends Mapper<SceneInvestigation> {

	/**
	 * 逻辑删除多个
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月23日
	 */
	public void deleteAllScene(String ids);

	/**
	 * 查询最大复堪值
	 * 方法功能说明：  
	 * 创建：2016-12-27 下午3:22:43 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public int findMaxIterationNoByInvestigationNo(String investigationNo);

	
	/**
	 * 查询全部单位个人现场数
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月27日
	 */
	public SceneInvestigation queryCount(SceneInvestigation sceneInvestigation);

	/**
	 * 查询个人关注现场数
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月27日
	 */
	public SceneInvestigation followCount(SceneInvestigation sceneInvestigation);
	
	

}
