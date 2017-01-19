/**
 * DictCommMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.DictComm;

/**
 * 常用字典信息Mapper
 *
 * @author MapperGenerator
 */
public interface DictCommMapper extends Mapper<DictComm> {

	/**
	 * 根据dictType和用户id删除常用项
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月16日
	 */
	public void deleteBy(DictComm dictComm);

	/**
	 * 查找发案区划常用项
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月16日
	 */
	public List<DictComm> queryCaseReg(DictComm filter);
	
}
