/**
 * QueryHistoryService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import com.hisign.xcky.api.model.sceneCollecting.QueryHistory;
import com.hisign.xcky.common.JsonResult;

/**
 * 历史查询条件Service
 *
 * @author ServiceGenerator
 */
public interface QueryHistoryService {
	
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
    public JsonResult add(String token, QueryHistory t);
    
    /**
     * 查询本人全部数据
     * @param filter 查询条件对象
     */
    public JsonResult queryList(String token,QueryHistory filter);
    
}
