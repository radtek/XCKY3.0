/**
 * SceneInvestigationDispatchService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import java.util.Map;

import com.hisign.xcky.common.JsonResult;

/**
 * 现场接勘信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneInvestigationDispatchServiceInput {
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, Map<String,Object> map);

}
