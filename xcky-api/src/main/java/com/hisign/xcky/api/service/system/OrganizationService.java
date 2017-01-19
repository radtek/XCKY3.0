/**
 * OrganizationService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import java.util.List;

import com.hisign.xcky.api.model.system.Organization;
import com.hisign.xcky.common.JsonResult;

/**
 * 单位信息Service
 *
 * @author ServiceGenerator
 */
public interface OrganizationService {
	
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
	 * 方法功能说明：  获得单位字典
	 * 创建：2016-11-14 by hotdog   
	 * @参数： @param token 根据token获取当前用户（用户单位级别）
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult findDictUnit (String token) throws Exception;

/**
     * 根据id删除(逻辑删除)
     * @param id
     */
    public JsonResult deleteLogicById(String token, String id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, Organization t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, Organization t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<Organization> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(Organization filter);
    /**
     * 根据机构代码查询本机构
     * 方法功能说明：  
     * 创建：2016-12-27 下午1:02:55 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public Organization getByRegionalism(String regionalism);
	/**
	 * 根据机构代码查询子机构
	 * 方法功能说明：  
	 * 创建：2016-12-27 下午1:12:02 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<Organization> findListByParentRegionalism(String regionalism);
}
