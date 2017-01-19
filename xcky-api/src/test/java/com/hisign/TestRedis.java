package com.hisign;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Redis测试类 参考地址：http://www.runoob.com/redis/redis-java.html
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年10月17日
 */
public class TestRedis {

	public static void main(String[] args) {
		//连接本地的 Redis 服务
	      Jedis jedis = new Jedis("172.16.0.55",6379);
	      jedis.auth("xcky");
	      System.out.println("Connection to server sucessfully");
	      //设置 redis 字符串数据
	      jedis.set("runoobkey", "Redis tutorial");
	     // 获取存储的数据并输出
	     System.out.println("Stored string in redis:: "+ jedis.get("runoobkey"));
	     
	   //存储数据到列表中
	      /*jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");*/
	      /*jedis.del("tutorial-list");*/
	     // 获取存储的数据并输出
	     List<String> list = jedis.lrange("tutorial-list", 0 ,100);
	     for(int i=0; i<list.size(); i++) {
	       System.out.println(i+"Stored string in redis:: "+list.get(i));
	     }
	     
	  // 获取数据并输出
	     Set<String> set = jedis.keys("*");
	     for(String key : set){
	    	 System.out.println("List of stored keys:: "+key);
	     }
	}
}
