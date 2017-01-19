/**
 * SceneOffenderMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneOffender;

/**
 * 现场涉案人员信息Mapper
 *
 * @author MapperGenerator
 */
public interface SceneOffenderMapper extends Mapper<SceneOffender> {
	/**
	 * 涉案人员集合根据勘验ID和人员类型
	 * 方法功能说明：  
	 * 创建：2016-12-9 上午11:17:13 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneOffender> findListBySQL(String sql);


}
