package com.hisign.xcky.api.service;

/**
 * kafka发送消息接口
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2016年11月25日
 */
public interface IKafkaSendService {

	/**
	 * 发送消息
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年11月25日
	 */
	public void sendMsg(Object object);
}
