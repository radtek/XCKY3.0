/**
 * SysOnlineLogMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.system;

import com.hisign.xcky.api.model.system.SysOnlineLog;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 系统登录日志信息Mapper
 *
 * @author MapperGenerator
 */
public interface SysOnlineLogMapper extends Mapper<SysOnlineLog> {

	void updateByToken(SysOnlineLog sysOnlineLog);

}
