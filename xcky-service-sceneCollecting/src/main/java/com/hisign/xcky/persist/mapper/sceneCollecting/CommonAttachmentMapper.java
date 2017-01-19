/**
 * CommonAttachmentMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.CommonAttachment;

/**
 * 通用附件信息Mapper
 *
 * @author MapperGenerator
 */
public interface CommonAttachmentMapper extends Mapper<CommonAttachment> {
	/**
	 * 根据勘验ID和文件类型获取
	 * 方法功能说明：  
	 * 创建：2016-12-23 下午2:04:24 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public CommonAttachment findByInvestigationIdAndCategory(CommonAttachment commonAttachment);
}
