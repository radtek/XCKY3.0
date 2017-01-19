package com.hisign.xcky.api.model.template;

/**
 * 笔录图片
 * 项目名称：xcky-api   
 * 类名称：WordScenePicture   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-23 上午11:48:02   
 * 修改人：hisign   
 * 修改时间：2016-12-23 上午11:48:02   
 * 修改备注：   
 * @version
 */
public class WordScenePicture {

	String name;
	
	String pictureBase64str;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureBase64str() {
		return pictureBase64str;
	}

	public void setPictureBase64str(String pictureBase64str) {
		this.pictureBase64str = pictureBase64str;
	}
	
	
}
