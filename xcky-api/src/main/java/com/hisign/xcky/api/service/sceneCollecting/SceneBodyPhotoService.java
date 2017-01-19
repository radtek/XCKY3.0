/**
 * SceneBodyPhotoService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneBodyPhoto;
import com.hisign.xcky.common.JsonResult;

/**
 * 尸体照片信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneBodyPhotoService {
	
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
     * 根据id删除(逻辑删除)
     * @param id
     */
    public JsonResult deleteLogicById(String token, String id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, SceneBodyPhoto t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneBodyPhoto t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneBodyPhoto> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SceneBodyPhoto filter);
    
}
