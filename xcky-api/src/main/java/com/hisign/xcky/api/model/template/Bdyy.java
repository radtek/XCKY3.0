package com.hisign.xcky.api.model.template;

/**
 * 用于生成word模板的  天气对象
 * */
public class Bdyy {
	//变动原因
	private String BDYY;
	//是否选中
	private String ifCheck;
	//变动原因：其他
	private String BDYYDESC;
	public String getIfCheck() {
		return ifCheck;
	}
	public void setIfCheck(String ifCheck) {
		this.ifCheck = ifCheck;
	}
	public String getBDYY() {
		return BDYY;
	}
	public void setBDYY(String BDYY) {
		this.BDYY = BDYY;
	}
	public String getBDYYDESC() {
		return BDYYDESC;
	}
	public void setBDYYDESC(String bdyydesc) {
		BDYYDESC = bdyydesc;
	}
}
