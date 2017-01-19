package com.hisign.xcky.service.impl;

import org.springframework.stereotype.Service;

import com.hisign.sdk.msg.Message;
import com.hisign.sdk.msg.MessageClient;
import com.hisign.xcky.api.service.IKafkaSendService;

/**
 * kafka发送消息接口实现类
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2016年11月25日
 */
@Service("kafkaSendService")
public class KafkaSendServiceImpl implements IKafkaSendService{

	@Override
	public void sendMsg(Object object) {
		//构建消息
		Message<String> msg1 = new Message<String>();
		msg1.setType(600001); //新建Person
		msg1.setTopic("XCKY_topic1"); //消息topic
		msg1.setUserObject("111");
		try {
			MessageClient.getInstance().send(msg1);
			System.out.println("send msg1 successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
