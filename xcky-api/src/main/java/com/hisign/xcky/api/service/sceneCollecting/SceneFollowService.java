/**
 * SceneFollowService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneFollow;
import com.hisign.xcky.common.JsonResult;

/**
 * 关注现场Service
 *
 * @author ServiceGenerator
 */
public interface SceneFollowService {
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);

    /**
     * 根据id删除(物理删除)
     * @param id
     */
    public JsonResult deleteById(String token, String id);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneFollow t);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(String token,SceneFollow filter);
    
}
