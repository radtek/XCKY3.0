/**
 * InvestigatorHistoryMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;
import java.util.Map;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.InvestigatorHistory;

/**
 * 历史勘验人信息Mapper
 *
 * @author MapperGenerator
 */
public interface InvestigatorHistoryMapper extends Mapper<InvestigatorHistory> {
	/**
	 * 查询指挥人员
	 * 方法功能说明：  
	 * 创建：2016-12-6 下午1:31:14 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<InvestigatorHistory> queryCommander(InvestigatorHistory filter);
	/**
	 * 查询勘验人员
	 * 方法功能说明：  
	 * 创建：2016-12-6 下午1:31:24 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<InvestigatorHistory> queryInquest(InvestigatorHistory filter);
	/**
	 * 更新当前用户下的数据全部为非勘验组
	 * 方法功能说明：  
	 * 创建：2016-12-30 上午10:43:42 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void updateIsOpenByUser(String id);
	/**
	 * 根据条件删除
	 * 方法功能说明：  
	 * 创建：2016-12-30 上午10:54:54 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void deleteByMap(Map<String, String> map);
	/**
	 * 删掉就数据
	 * 方法功能说明：  
	 * 创建：2017-1-6 下午4:20:47 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void deleteByCreateUserId(InvestigatorHistory investigatorHistory);


}
