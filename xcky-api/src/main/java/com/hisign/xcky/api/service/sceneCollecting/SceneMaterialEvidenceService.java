/**
 * SceneMaterialEvidenceService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneMaterialEvidence;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场痕迹物证信息Service
 *
 * @author ServiceGenerator
 */
public interface SceneMaterialEvidenceService {
	
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
    public JsonResult updateById(String token, SceneMaterialEvidence t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneMaterialEvidence t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneMaterialEvidence> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SceneMaterialEvidence filter);
    /**
     * 根据ID查询痕迹物证
     * 方法功能说明：  
     * 创建：2016-12-12 下午3:05:00 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public List<SceneMaterialEvidence> findListByInvestigationId(String investigationId);
	/**
	 * 更新数据
	 * 方法功能说明：  
	 * 创建：2016-12-14 下午6:06:11 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void updateByObj(String token, SceneMaterialEvidence obj);
    
}
