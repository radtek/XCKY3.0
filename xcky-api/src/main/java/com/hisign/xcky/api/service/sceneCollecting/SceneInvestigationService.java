/**
 * SceneInvestigationService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;
import java.util.Map;

import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场勘验信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneInvestigationService {
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);

    /**
     * 根据id删除(逻辑删除)
     * @param id
     */
    public JsonResult deleteLogicById(String token, String id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, SceneInvestigation t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneInvestigation t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneInvestigation> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(String token, SceneInvestigation filter);
    /**
     * 查询勘验信息实体根据ID
     * 方法功能说明：  
     * 创建：2016-12-12 下午2:20:13 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public SceneInvestigation findById(String investigationId);
	/**
     * 导出
     * @param filter 查询条件对象
	 * @return 
     */
	public JsonResult expendAll(String token, SceneInvestigation t);
		
    /**
     * 根据ids删除(逻辑删除)
     * @param id
     */
    public JsonResult delAllLogic(String token, List<Map<String,String>> list);
    
    /**
     * 现场查询页面统计
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com.cn
     * 2016年12月27日
     */
    public JsonResult queryCount(String token);
    
    /**
     * 获取最大复堪号
     * 方法功能说明：  
     * 创建：2016-12-27 下午3:20:39 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public int findMaxIterationNoByInvestigationNo(String investigationNo);

	
}
