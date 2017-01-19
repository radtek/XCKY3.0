/**
 * SysXtdhMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.system;

import com.hisign.xcky.api.model.system.SysXtdh;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 系统导航信息表Mapper
 *
 * @author MapperGenerator
 */
public interface SysXtdhMapper extends Mapper<SysXtdh> {

	/**
	 * 图片添加
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月15日
	 */
	public void photoUpdate(SysXtdh sysXtdh);

}
