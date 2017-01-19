/**
 * AlarmInfoMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.model.sceneCollecting.AlarmInfo;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 警情信息Mapper
 *
 * @author MapperGenerator
 */
public interface AlarmInfoMapper extends Mapper<AlarmInfo> {

	/**
	 * 警情关联
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月30日
	 */
	public void updateSceneInvestigationDispatch(AlarmInfo tempAlarmInfo);


}
