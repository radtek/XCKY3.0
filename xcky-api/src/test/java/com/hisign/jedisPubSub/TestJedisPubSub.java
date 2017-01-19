package com.hisign.jedisPubSub;

import redis.clients.jedis.JedisPubSub;

/**
 * redis订阅
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年10月17日
 */
public class TestJedisPubSub extends JedisPubSub{

	private String userName;
	
	public TestJedisPubSub(String userName){
		this.userName=userName;
	}
	
	@Override
	public void onMessage(String channel, String message) {
		System.out.println(userName+" channe：" + channel + " receives message：" + message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		
	}

}
