/**
 * OrganizationMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.system;

import java.util.List;

import com.hisign.xcky.api.model.system.Organization;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 单位信息Mapper
 *
 * @author MapperGenerator
 */
public interface OrganizationMapper extends Mapper<Organization> {


	/**  
	 * 方法功能说明：  获得全部单位字典
	 * 创建：2016-11-14 by hotdog   
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return List<Organization>
	 */  
	public List<Organization> findAllDictUnit () throws Exception;
	
	public List<Organization> findDictUnitByUnitCode () throws Exception;
	/**
	 * 本机机构
	 * 方法功能说明：  
	 * 创建：2016-12-27 下午1:04:02 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public Organization getByRegionalism(String regionalism);
	/**
	 * 根据代码查询子单位
	 * 方法功能说明：  
	 * 创建：2016-12-27 下午1:10:13 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<Organization> findListByParentRegionalism(String regionalism);
}
