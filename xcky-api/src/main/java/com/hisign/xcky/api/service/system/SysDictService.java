/**
 * SysDictService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.system;

import java.util.List;

import com.hisign.xcky.api.model.system.SysDict;
import com.hisign.xcky.common.JsonResult;

/**
 * 系统字典信息Service
 *
 * @author ServiceGenerator
 */
public interface SysDictService {

	/**
	 * 根据父key查找list
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月11日
	 */
	public List<SysDict> findByParentKey(String rootKey);

	/**  
	 * 方法功能说明：  根据ROOT_KEY查询单级字典
	 * 创建：2016-11-12 by hotdog   
	 * @参数： @param root
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult findSingleDictByRootKey (String root) throws Exception;

	/**
	 * 方法功能说明：  根据ROOT_KEY(字典类型)和DICT_KEY(字典代码值)查询单级字典
	 * @return
	 * @throws Exception
	 */
	public JsonResult findDictByRootAndKey (String root, String keys) throws Exception;

	/**
	 * 查找树形节点
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月6日
	 */
	public JsonResult findTreeListByKey(String rootKey);
	
	/**
	 * 根据子节点查找父节点
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月13日
	 */
	public List<SysDict> findParentByKey(String dictKey);
	/**
	 * 查询显示中文
	 * 方法功能说明：  
	 * 创建：2016-12-21 下午3:56:14 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public String findSysDictValueByKeys(String dictKey, String rootKey);
}
