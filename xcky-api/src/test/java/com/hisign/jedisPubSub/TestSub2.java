package com.hisign.jedisPubSub;

import redis.clients.jedis.Jedis;

public class TestSub2 {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("172.16.0.55",6379);
	    jedis.auth("xcky");
		TestJedisPubSub listener = new TestJedisPubSub("TestSub2");
        jedis.subscribe(listener, "redisChatTest");
	}
}
