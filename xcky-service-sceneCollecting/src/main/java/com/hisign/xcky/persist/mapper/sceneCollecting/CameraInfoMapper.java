package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.CameraInfo;
import com.hisign.xcky.api.persist.Mapper;

public interface CameraInfoMapper extends Mapper<CameraInfo>{
	/**
	 * 根据勘验ID查询
	 * 方法功能说明：  
	 * 创建：2016-12-19 下午2:11:11 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<CameraInfo> findListByInvestigationId(String investigationId);

}
