/**
 * SceneInvestigationDispatchService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationDispatch;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场接勘信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneInvestigationDispatchService {
	
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
    public JsonResult updateById(String token, SceneInvestigationDispatch t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneInvestigationDispatch t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneInvestigationDispatch> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SceneInvestigationDispatch filter);
    /**
     * 根据勘验ID查询现场勘验接警
     * 方法功能说明：  
     * 创建：2016-12-12 下午2:03:10 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public SceneInvestigationDispatch getByInvestigationId(String investigationId);
    
}
