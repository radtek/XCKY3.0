/**
 * CommonAttachmentService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.CommonAttachment;
import com.hisign.xcky.common.JsonResult;

/**
 * 通用附件信息Service
 *
 * @author ServiceGenerator
 */
public interface CommonAttachmentService {
	
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
    public JsonResult updateById(String token, CommonAttachment t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, CommonAttachment t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<CommonAttachment> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(CommonAttachment filter);
    /**
     * 根据附件数据
     * 方法功能说明：  
     * 创建：2016-12-23 下午2:02:24 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public JsonResult saveOrUpdate(String token, CommonAttachment commonAttachment);
	
	/**
	 * 根据条件查询所有附件信息
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月26日
	 */
	public List<CommonAttachment> queryAll(CommonAttachment commonAttachment);
	/**
	 * 根据勘验号查询勘验笔录
	 * 方法功能说明：  
	 * 创建：2017-1-4 下午1:21:13 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public CommonAttachment findInvestigationNoteDownLoad(String investigationId);
	
    
}
