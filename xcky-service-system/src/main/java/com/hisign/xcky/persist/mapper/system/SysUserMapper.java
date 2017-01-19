/**
 * SysUserMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.system;

import java.util.List;

import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 系统用户信息Mapper
 *
 * @author MapperGenerator
 */
public interface SysUserMapper extends Mapper<SysUser> {

	/**
	 * 查询所有人员
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月20日
	 */
	public List<SysUser> queryTree(SysUser sysUser);


}
