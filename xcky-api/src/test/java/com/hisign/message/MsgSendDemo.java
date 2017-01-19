package com.hisign.message;

import com.hisign.sdk.msg.Message;
import com.hisign.sdk.msg.MessageClient;

public class MsgSendDemo {
	public void sendMessage(){
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

	public static void main(String[] args) {
		MsgSendDemo demo = new MsgSendDemo();
		demo.sendMessage();
	}

}
