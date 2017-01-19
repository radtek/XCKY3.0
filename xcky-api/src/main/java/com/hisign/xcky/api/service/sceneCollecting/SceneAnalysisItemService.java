/**
 * SceneAnalysisItemService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisItem;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场分析意见项目Service
 *
 * @author ServiceGenerator
 */
public interface SceneAnalysisItemService {
	
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
    public JsonResult updateById(String token, SceneAnalysisItem t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneAnalysisItem t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneAnalysisItem> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SceneAnalysisItem filter);
    /**
     * 根据勘验ID查询分析意见项
     * 方法功能说明：  
     * 创建：2016-12-12 下午3:42:22 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public List<SceneAnalysisItem> findByInvestigationId(String investigationId);


	/**
	 * 根据勘验id和itemType进行删除
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2017年1月12日
	 */
	public void deleteByItemType(SceneAnalysisItem sceneAnalysisItem);
    
}
