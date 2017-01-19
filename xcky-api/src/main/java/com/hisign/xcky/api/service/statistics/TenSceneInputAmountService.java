package com.hisign.xcky.api.service.statistics;



import com.hisign.xcky.api.model.statistics.SceneInputAmountFilter;
import com.hisign.xcky.common.JsonResult;

/**
 * 十类统计结果查询
 * 项目名称：xcky-api   
 * 类名称：TenSceneInputAmountService   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-26 下午1:10:00   
 * 修改人：hisign   
 * 修改时间：2016-12-26 下午1:10:00   
 * 修改备注：   
 * @version
 */
public interface TenSceneInputAmountService {

	public JsonResult query(String token,SceneInputAmountFilter t);
	/**
	 * 导出excel
	 * 方法功能说明：  
	 * 创建：2016-12-28 下午3:53:29 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult expendAll(String token, SceneInputAmountFilter filter);
}
