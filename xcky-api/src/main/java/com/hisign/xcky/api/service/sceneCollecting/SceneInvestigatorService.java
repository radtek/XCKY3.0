/**
 * SceneInvestigatorService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigator;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场勘验人信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneInvestigatorService {
	
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
    public JsonResult updateById(String token, SceneInvestigator t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneInvestigator t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneInvestigator> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SceneInvestigator filter);
    /**
     * 根据勘验ID查询勘验人实体集合
     * 方法功能说明：  
     * 创建：2016-12-12 下午2:21:46 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public List<SceneInvestigator> findListByInvestigationId(String investigationId);
	/**
	 * 根据勘验ID查询指挥人员详情（姓名、机构、职务）
	 * 方法功能说明：  
	 * 创建：2016-12-21 下午5:22:40 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<SceneInvestigator> findCommandListByInvestigationId(String investigationId, String type);

	public void saveOrUpdate(String token,List<SceneInvestigator> sceneInvestigatorList);
    
}
