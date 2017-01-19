/**
 * SceneInvestigationDispatchService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting.input;

import java.util.Map;

import com.hisign.xcky.common.JsonResult;

/**
 * 信息录入接口
 *
 * @author ServiceGenerator
 */
public interface SceneInfoInputService {
	/**
	 * 查询案件信息
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:32:15 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findDispatchByInvestigationId(String investigationId);
	/**
	 * 查询出堪信息
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:32:41 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findOutInvestigation(String investigationId);
	/**
	 * 查询现场条件
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:33:33 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findConditionByInvestigationId(String investigationId);
	/**
	 * 查询现场图、现场照片
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:34:02 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findPictureByInvestigationId(String investigationId,String category);
	/**
	 * 查询痕迹物证
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:34:36 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findMaterialEvidenceByInvestigationId(String investigationId);
	/**
	 * 查询提取物品
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:35:09 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findCollectedGoodsByInvestigationId(String investigationId);
	/**
	 * 查询勘验信息
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:45:38 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findInvestigationByInvestigationId(String investigationId);
	/**
	 * 查询分析意见
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:45:47 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findAnalysisSuggestionByInvestigationId(String investigationId);
	
	/**
	 * 查询实体信息
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午1:45:47 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findBodyBasicByInvestigationId(String investigationId);
	
	/**
	 * 表单定时保存到缓存
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:24:07 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult saveToCache(String token, Map<String, Object> map);
	
	/**
	 * 定时获取上次未完成的表单
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:59:52 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult getFromCache(String token);
	
	/**
	 * 保存
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:59:52 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult save(String token, Map<String, Object> map);
	
	/**
	 * 提交
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:59:52 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult summit(String token, Map<String, Object> map);
	/**
	 * 案件信息修改
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult dispatchUpd(String token, Map<String, Object> map);
	/**
	 * 修改出堪信息
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult outInvestigationUpd(String token, Map<String, Object> map);
	/**
	 * 修改现场条件信息
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult conditionUpd(String token, Map<String, Object> map);
	/**
	 * 修改现场图、现场照片信息
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult pictureUpd(String token, Map<String, Object> map);
	/**
	 * 修改痕迹物证信息
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult materialEvidenceUpd(String token, Map<String, Object> map);
	/**
	 * 修改提取物信息
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult collectedGoodsUpd(String token, Map<String, Object> map);
	/**
	 * 修改勘验情况
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult investigationUpd(String token, Map<String, Object> map);
	/**
	 * 修改分析意见
	 * 方法功能说明：  
	 * 创建：2016-12-13 下午2:05:28 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult analysisSuggestionUpd(String token, Map<String, Object> map);
	/**
	 * 修改尸体信息
	 * 方法功能说明：  
	 * 创建：2016-12-14 下午2:22:11 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult bodyBasicsUpd(String token, Map<String, Object> map);
}
