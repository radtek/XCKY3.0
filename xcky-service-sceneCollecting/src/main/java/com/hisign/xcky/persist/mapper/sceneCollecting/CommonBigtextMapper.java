/**
 * CommonBigtextMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.CommonBigtext;

/**
 * 通用文本信息Mapper
 *
 * @author MapperGenerator
 */
public interface CommonBigtextMapper extends Mapper<CommonBigtext> {
	/**
	 * 根据勘验ID查询大文本
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午3:25:43 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public CommonBigtext findByInvestigationId(String investigationId);


}
