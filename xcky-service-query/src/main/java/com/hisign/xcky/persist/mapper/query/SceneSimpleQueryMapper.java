package com.hisign.xcky.persist.mapper.query;

import java.util.List;
import java.util.Map;

import com.hisign.xcky.api.model.sceneQuery.SceneSimpleQuery;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2017年1月9日
 */
public interface SceneSimpleQueryMapper  extends Mapper<SceneSimpleQuery> {

	/**
	 * 简单查询
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月9日
	 */
	public List<SceneSimpleQuery> queryAll(Map<String, Object> map);
	
}
