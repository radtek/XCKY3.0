package com.hisign.xcky.api.model.template;
/**
 * 用于现场保护手段对象
 * 项目名称：xcky-api   
 * 类名称：WordProtected   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-20 下午4:02:41   
 * 修改人：hisign   
 * 修改时间：2016-12-20 下午4:02:41   
 * 修改备注：   
 * @version
 */
public class WordProtected {
	// 是否选中
	private String ifCheck = "";
	// 保护手段
	private String protectWay = "";

	public String getIfCheck() {
		return ifCheck;
	}

	public void setIfCheck(String ifCheck) {
		this.ifCheck = ifCheck;
	}

	public String getProtectWay() {
		return protectWay;
	}

	public void setProtectWay(String protectWay) {
		this.protectWay = protectWay;
	}
}
