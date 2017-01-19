/**
 * BasestationInfoService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.BasestationInfo;
import com.hisign.xcky.common.JsonResult;

/**
 * 基站信息Service
 *
 * @author ServiceGenerator
 */
public interface BasestationInfoService {
	
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
    public JsonResult updateById(String token, BasestationInfo t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, BasestationInfo t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<BasestationInfo> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(BasestationInfo filter);

	/**
	 * 根据勘验id删除所有基站信息
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月26日
	 */
	public void deleteAllLogicById(String token, String investigationId);
	
    /**
     * 根据文件名，勘验id，附件id查询基站信息
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com.cn
     * 2017年1月13日
     */
    public JsonResult queryAll(BasestationInfo filter);
    
}
