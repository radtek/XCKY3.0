/**
 * DictCommService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.DictComm;
import com.hisign.xcky.common.JsonResult;

/**
 * 常用字典信息Service
 *
 * @author ServiceGenerator
 */
public interface DictCommService {
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);
    
    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(DictComm filter);
    
    /**
     * 查询全部
     * @param filter 查询条件对象
     */
    public JsonResult queryAll(String token,DictComm filter);
    

    /**
     * 根据id删除(物理删除)
     * @param id
     */
    public JsonResult deleteById(String token, String id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, DictComm t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, DictComm t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<DictComm> list);

}
