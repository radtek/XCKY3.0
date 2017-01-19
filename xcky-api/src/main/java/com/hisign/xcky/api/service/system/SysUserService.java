/**
 * SysUserService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.common.JsonResult;

/**
 * 系统用户信息Service
 *
 * @author ServiceGenerator
 */
public interface SysUserService{

	/**  
	 * 方法功能说明：  根据ID查询用户信息
	 * 创建：2016-11-11 by hotdog   
	 * @参数： @param userId 用户id
	 * @参数： @param type 根据类型不同获取更多信息
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult view(String userId, String type) throws Exception;
	
	/**  
	 * 方法功能说明： 用户新增 
	 * 创建：2016-11-12 by hotdog   
	 * @参数： @param t
	 * @参数： @param token
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult add(SysUser t, String token) throws Exception;
	
	/**  
	 * 方法功能说明：  用户修改
	 * 创建：2016-11-14 by hotdog   
	 * @参数： @param t
	 * @参数： @param token
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult update(SysUser t, String token) throws Exception;
	
	/**  
	 * 方法功能说明：  用户逻辑删除
	 * 创建：2016-11-14 by hotdog   
	 * @参数： @param t
	 * @参数： @param token
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult deleteLogic(SysUser t, String token) throws Exception;
	
	/**  
	 * 方法功能说明：  根据userId列表删除用户
	 * 创建：2016-11-15 by hotdog   
	 * @参数： @param userIds
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult deleteByUserIds (String userIds) throws Exception;
	
	/**  
	 * 方法功能说明：分页查询  
	 * 创建：2016-11-12 by hotdog   
	 * @参数： @param t
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult pagequery(SysUser t) throws Exception;
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, SysUser t);
    
    
    /**
     * 查询树结构的用户列表
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com.cn
     * 2016年12月20日
     */
    public JsonResult queryTreeUser(String token,SysUser sysUser);
    
    /**
     * 模糊查询所有用户表
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com.cn
     * 2016年12月21日
     */
    public JsonResult queryAll (String token,SysUser sysUser);
	
}
