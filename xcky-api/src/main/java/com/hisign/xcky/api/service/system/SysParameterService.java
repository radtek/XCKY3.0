/**
 * SysParameterService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import java.util.List;

import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.common.JsonResult;

/**
 * 系统参数配置Service
 *
 * @author ServiceGenerator
 */
public interface SysParameterService {
	
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
    public JsonResult updateById(String token, SysParameter t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SysParameter t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SysParameter> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SysParameter filter);

	/**
	 * 查询系统参数
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月14日
	 */
	public JsonResult list();

	/**
	 * 根据key查找
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月14日
	 */
	public SysParameter getByKey(String key);
	
	/**
	 * 根据key更新value
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月29日
	 */
	public JsonResult updateByKey( String token,String paramArray);
	
    
}
