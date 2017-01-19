package com.hisign.xcky.api.service.sceneCollecting;

import com.hisign.xcky.common.JsonResult;

/**
 * 生成勘验笔录接口
 * 项目名称：xcky-api   
 * 类名称：SceneInvestigationNoteWordManagerService   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-20 下午5:44:13   
 * 修改人：hisign   
 * 修改时间：2016-12-20 下午5:44:13   
 * 修改备注：   
 * @version
 */
public interface WordManagerService {
	/**
	 * @throws Exception 
	 * 勘验笔录生成接口
	 * 方法功能说明：  
	 * 创建：2016-12-21 上午9:29:46 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult createInvestigationNoteByInvestigationId(String token,String investigationId) throws Exception;
	/**
	 * 勘验笔录下载地址
	 * 方法功能说明：  
	 * 创建：2017-1-4 下午1:19:29 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public JsonResult findInvestigationNoteDownLoad(String token,String investigationId);

}
