/**
 * SceneInvestigationStatusService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationStatus;
import com.hisign.xcky.common.JsonResult;

/**
 * 现场勘验信息状态Service
 *
 * @author ServiceGenerator
 */
public interface SceneInvestigationStatusService {
	
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
    public JsonResult updateById(String token, SceneInvestigationStatus t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SceneInvestigationStatus t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SceneInvestigationStatus> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SceneInvestigationStatus filter);
    /**
     * 根据勘验ID修改状态
     * 方法功能说明：  
     * 创建：2016-12-23 下午2:14:39 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public void updateByInvestigationId(String token,SceneInvestigationStatus sceneInvestigationStatus);
	/**
     * 更改可修改状态
     * 方法功能说明：  
     * 创建：2016年12月27日14:34:24 by wangk
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public JsonResult updateByList(String token, List<SceneInvestigationStatus> list);

	/**
	 * 更新现勘数据
	 * 方法功能说明：  
	 * 创建：2016-12-23 下午2:30:07 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void addOrupdate(String token,SceneInvestigationStatus sceneInvestigationStatus);

    
}
