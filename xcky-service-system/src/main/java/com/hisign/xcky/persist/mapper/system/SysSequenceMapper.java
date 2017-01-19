package com.hisign.xcky.persist.mapper.system;

import com.hisign.xcky.api.model.system.SysSequence;
import com.hisign.xcky.api.persist.Mapper;

/**
 * 流水号持久层业务接口
 * 项目名称：xcky-service-system   
 * 类名称：SysSequenceMapper   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-8 下午4:03:26   
 * 修改人：hisign   
 * 修改时间：2016-12-8 下午4:03:26   
 * 修改备注：   
 * @version
 */
public interface SysSequenceMapper extends Mapper<SysSequence> {
	/**
	 * 根据对象属性获取对象最大流水号
	 * 方法功能说明：  
	 * 创建：2016-12-8 下午5:05:24 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SysSequence findMaxSeqByFilter(SysSequence filter);
	/**
	 * 根据ID和版本修改
	 * 方法功能说明：  
	 * 创建：2016-12-8 下午5:32:53 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void updateByIdAndVersionFlag(SysSequence t);
	/**
	 * 查询是否存在
	 * 方法功能说明：  
	 * 创建：2016-12-8 下午5:35:19 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SysSequence findSysSequenceByIdAndVersion(
			SysSequence filter2);

}
