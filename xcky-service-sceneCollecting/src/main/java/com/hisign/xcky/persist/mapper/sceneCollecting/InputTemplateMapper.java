/**
 * InputTemplateMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.InputTemplate;

/**
 * 信息录入模板Mapper
 *
 * @author MapperGenerator
 */
public interface InputTemplateMapper extends Mapper<InputTemplate> {

	/**
	 * 
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月7日
	 */
	public InputTemplate getByCaseType(String caseType);

	/**
	 * 查重
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月18日
	 */
	public List<InputTemplate> checkExist(String caseType);

}
