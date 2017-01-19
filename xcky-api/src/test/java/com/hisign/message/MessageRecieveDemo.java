package com.hisign.message;

import com.hisign.sdk.msg.Message;
import com.hisign.sdk.msg.MessageClient;
import com.hisign.sdk.msg.MessageHandler;

public class MessageRecieveDemo {
	public void receiveMsg(){
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

	public static void main(String[] args) throws Exception {
		System.setProperty("SYSTEMID", "XCKY");
		MessageRecieveDemo demo = new MessageRecieveDemo();
		demo.receiveMsg();
		System.in.read(); //等待，防止直接进程退出
	}

}
