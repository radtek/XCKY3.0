/**
 * InvestigatorHistoryService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.InvestigatorHistory;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigator;
import com.hisign.xcky.common.JsonResult;

/**
 * 历史勘验人信息Service
 *
 * @author ServiceGenerator
 */
public interface InvestigatorHistoryService {
	
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
    public JsonResult updateById(String token, InvestigatorHistory t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, InvestigatorHistory t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<InvestigatorHistory> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(InvestigatorHistory filter);
    /**
     * 不分页查询
     * @param filter 查询条件对象
     */
	public JsonResult queryAll(String token, InvestigatorHistory filter);
	/**
	 * 更新历史勘验人信息
	 * 方法功能说明：  
	 * 创建：2016-12-30 上午10:39:53 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void addBySceneInvestigators(String token,List<SceneInvestigator> list);
    
}
