package com.hisign.xcky.persist.mapper.statistics;

import com.hisign.xcky.api.model.statistics.SceneInputAmountFilter;
import com.hisign.xcky.api.model.statistics.TenSceneInputAmount;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 十类案件统计Mapper
 * 项目名称：xcky-service-statistics   
 * 类名称：TenSceneInputAmountMapper   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-26 下午1:25:44   
 * 修改人：hisign   
 * 修改时间：2016-12-26 下午1:25:44   
 * 修改备注：   
 * @version
 */
public interface TenSceneInputAmountMapper extends Mapper<TenSceneInputAmount>{
	/**
	 * 根据代码查询本机构或下级机构的
	 * 方法功能说明：  
	 * 创建：2016-12-27 下午1:20:51 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public TenSceneInputAmount getAountByRegionalism(SceneInputAmountFilter filter);

}
