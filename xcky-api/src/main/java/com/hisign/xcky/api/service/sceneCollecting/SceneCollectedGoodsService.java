/**
 * SceneCollectedGoodsService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场提取物品信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneCollectedGoodsService {
	
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
    public JsonResult updateById(String token, SceneCollectedGoods t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneCollectedGoods t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneCollectedGoods> list);

    /**
     * 根据勘验ID查询提取物
     * 方法功能说明：  
     * 创建：2016-12-12 下午3:12:12 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public List<SceneCollectedGoods> findListByInvestigationId(String investigationId);
	/**
	 * 更新数据
	 * 方法功能说明：  
	 * 创建：2016-12-14 下午6:06:35 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void updateByObj(String token, SceneCollectedGoods obj);
    
}
