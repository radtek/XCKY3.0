/**
 * BasestationInfoMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.BasestationInfo;

/**
 * 基站信息Mapper
 *
 * @author MapperGenerator
 */
public interface BasestationInfoMapper extends Mapper<BasestationInfo> {

	/**
	 * 根据勘验id逻辑删除基站信息
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月26日
	 */
	public void deleteAllLogicById(BasestationInfo t);

	/**
	 * 根据勘验id，附件id查询基站信息
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月13日
	 */
	public List<BasestationInfo> queryAll(BasestationInfo t);


}
