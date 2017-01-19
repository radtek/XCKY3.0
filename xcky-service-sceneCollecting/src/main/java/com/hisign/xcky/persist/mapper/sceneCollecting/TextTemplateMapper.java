/**
 * TextTemplateMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.TextTemplate;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 文本信息模板Mapper
 *
 * @author MapperGenerator
 */
public interface TextTemplateMapper extends Mapper<TextTemplate> {

	/**
	 *  根据模板类型、案件类型查询所有
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月8日
	 */
	public List<TextTemplate> getAllByType(TextTemplate t);


}
