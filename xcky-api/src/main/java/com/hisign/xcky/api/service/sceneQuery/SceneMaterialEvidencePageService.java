package com.hisign.xcky.api.service.sceneQuery;

import com.hisign.xcky.api.model.sceneQuery.PageFilter;
import com.hisign.xcky.common.JsonResult;

/**
 * 痕迹物证分页查询接口
 * 项目名称：xcky-api   
 * 类名称：SceneMaterialEvidencePageService   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2017-1-5 上午10:55:35   
 * 修改人：hisign   
 * 修改时间：2017-1-5 上午10:55:35   
 * 修改备注：   
 * @version
 */
public interface SceneMaterialEvidencePageService {
	/**
	 * 查询分页列表
	 * 方法功能说明：  
	 * 创建：2017-1-5 上午11:19:29 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult queryPage(String token, PageFilter t);

}
