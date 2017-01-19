/**
 * SceneInvestigationDispatchService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting.input;

import java.util.Map;

import com.hisign.xcky.common.JsonResult;

/**
 * 复堪信息录入接口
 *
 * @author ServiceGenerator
 */
public interface ReviewSceneInfoInputService {
	/**
	 * 保存
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:59:52 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult save(String token, Map<String, Object> map);
	
	/**
	 * 提交
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:59:52 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult summit(String token, Map<String, Object> map);
}
