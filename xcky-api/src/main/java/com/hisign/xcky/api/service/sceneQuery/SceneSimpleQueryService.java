package com.hisign.xcky.api.service.sceneQuery;

import com.hisign.xcky.api.model.sceneQuery.SceneSimpleQuery;
import com.hisign.xcky.common.JsonResult;

/**
 * 简单查询接口
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2016年12月28日
 */
public interface SceneSimpleQueryService {

	/**
	 * 简单查询
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月9日
	 */
	public JsonResult query(SceneSimpleQuery sceneSimpleQuery);
	
	/**
	 * 简单查询导出
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月9日
	 */
	public JsonResult export(SceneSimpleQuery sceneSimpleQuery);	
	
}
