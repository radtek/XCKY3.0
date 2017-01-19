/**
 * SysDictMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.system;

import java.util.List;

import com.hisign.xcky.api.model.system.SysDict;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 系统字典信息Mapper
 *
 * @author MapperGenerator
 */
public interface SysDictMapper extends Mapper<SysDict> {

	List<SysDict> findByParentKey(String rootKey);

	/**  
	 * 方法功能说明：  根据ROOT_KEY查询单级字典
	 * 创建：2016-11-12 by hotdog   
	 * @参数： @param rootKey
	 * @参数： @return      
	 * @return List<SysDict>
	 */  
	List<SysDict> findSingleDictByRootKey (String rootKey);
	
	/**
	 * 查找树形节点
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月6日
	 */
	List<SysDict> findTreeListByKey(String rootKey);
	
	/**
	 * 根据子节点查找父节点
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月13日
	 */
	List<SysDict> findParentByKey(String dictKey);
	/**
	 * 根据对象属性查询对象
	 * 方法功能说明：  
	 * 创建：2016-12-21 下午3:58:33 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	String findDictByobj(SysDict dict);
}
