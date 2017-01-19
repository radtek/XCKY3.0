package com.hisign.jedisPubSub;

import redis.clients.jedis.Jedis;

public class TestPub {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("172.16.0.55",6379);
	    jedis.auth("xcky");
        jedis.publish("redisChatTest", "2222");
	}
}
