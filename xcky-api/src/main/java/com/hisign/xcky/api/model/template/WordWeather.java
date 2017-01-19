package com.hisign.xcky.api.model.template;
/**
 * 用于生成word模板的  天气对象
 * */
public class WordWeather {
	//天气（放入值为阴晴雨雪雾）
	private String weather;
	//是否选中
	private String ifCheck;
	public String getIfCheck() {
		return ifCheck;
	}
	public void setIfCheck(String ifCheck) {
		this.ifCheck = ifCheck;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
}
