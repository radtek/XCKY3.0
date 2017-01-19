/**
 * SysOnlineLogService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import java.util.List;

import com.hisign.xcky.api.model.system.SysOnlineLog;
import com.hisign.xcky.common.JsonResult;

/**
 * 系统登录日志信息Service
 *
 * @author ServiceGenerator
 */
public interface SysOnlineLogService {
	
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
    public JsonResult updateById(String token, SysOnlineLog t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, SysOnlineLog t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<SysOnlineLog> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(SysOnlineLog filter);
    
	/**
	 * 根据token更新数据
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月10日
	 */
	public void updateByToken(SysOnlineLog sysOnlineLog) throws Exception;
    
}
