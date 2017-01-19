/**
 * SysXtdhService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import java.util.List;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.springframework.web.multipart.MultipartFile;

import com.hisign.xcky.api.model.system.SysXtdh;
import com.hisign.xcky.common.JsonResult;

/**
 * 系统导航信息表Service
 *
 * @author ServiceGenerator
 */
public interface SysXtdhService {
	
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
    public JsonResult updateById(String token, SysXtdh t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SysXtdh t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SysXtdh> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SysXtdh filter);

	/**
	 * 图片文件上传
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月15日
	 */
	public JsonResult photoAdd(String token, MultipartFormDataInput input, String id);
    
}
