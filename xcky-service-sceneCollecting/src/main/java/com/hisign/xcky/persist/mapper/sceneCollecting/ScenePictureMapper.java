/**
 * ScenePictureMapper.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.persist.mapper.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicture;

/**
 * 现场图、现场照片信息Mapper
 *
 * @author MapperGenerator
 */
public interface ScenePictureMapper extends Mapper<ScenePicture> {
	/**
	 * 根据属性查询现场图片和现场照片
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午2:41:32 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public List<ScenePicture> findListByFilter(ScenePicture filter);


}
