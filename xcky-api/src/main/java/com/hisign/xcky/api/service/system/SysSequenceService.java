package com.hisign.xcky.api.service.system;

/**
 * 流水号业务接口
 * 项目名称：xcky-api   
 * 类名称：SysSequenceService   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-8 下午3:42:08   
 * 修改人：hisign   
 * 修改时间：2016-12-8 下午3:42:08   
 * 修改备注：   
 * @version
 */
public interface SysSequenceService {
	
	/**
	 * 获取流水号
	 * 方法功能说明：  
	 * 创建：2016-12-8 下午3:42:54 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public String getNextSerialNo(String seqType,String token);
}
