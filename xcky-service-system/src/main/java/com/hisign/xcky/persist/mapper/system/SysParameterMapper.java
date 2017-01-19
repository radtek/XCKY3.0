/**
 * SysParameterMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.system;

import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 系统参数配置Mapper
 *
 * @author MapperGenerator
 */
public interface SysParameterMapper extends Mapper<SysParameter> {

	/**
	 * 根据key查找
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月14日
	 */
	public SysParameter getByKey(String key);
	
	/**
	 * 根据key更新系统参数
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月29日
	 */
	public void updateByKey(SysParameter sysParameter);
}
