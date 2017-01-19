package com.hisign.xcky.service.impl;

import org.springframework.stereotype.Service;

import com.hisign.sdk.msg.Message;
import com.hisign.sdk.msg.MessageClient;
import com.hisign.sdk.msg.MessageHandler;
import com.hisign.xcky.api.service.IKafkaReceiveService;

/**
 * kafka接收消息接口实现类
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2016年11月25日
 */
@Service("kafkaReceiveService")
public class KafkaReceiveServiceImpl implements IKafkaReceiveService{

	@Override
	public void receiveMsg() {
		try{
				MessageClient.getInstance().addMessageHandler("XCKY_topic1", new MessageHandler(){
					@SuppressWarnings("rawtypes")
					@Override
					public void onMessage(Message msg) {
						if(msg.getType() == 600001){ //只处理新建Person消息类型
							String	result = (String)msg.getUserObject();
						    System.out.println("receive msg userObject="+result);
						}
					}
			});
			System.out.println("start receiveMsg completey!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
	}

}
