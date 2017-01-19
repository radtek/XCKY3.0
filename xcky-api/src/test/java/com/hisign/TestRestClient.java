package com.hisign;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TestRestClient {
	
	private static void login(){
		Map<String ,String> map = new HashMap<String ,String>();
		map.put("username", "admin");
		map.put("password", "admin");
		String body = JSON.toJSONString(map);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity rs = new HttpEntity(body, headers);
		String url = "http://localhost:8022/xcky/login/login";
		Map<String,String> rpResult = new RestTemplate().postForObject(url, rs, Map.class);
		System.out.println(rpResult);
	}
	
	private static void logout(){
		String body = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("token", "1a79d79e4632a1a738bcf27a21dba424");
		HttpEntity rs = new HttpEntity(body, headers);
		String url = "http://localhost:8022/xcky/login/logout";
		Map<String,String> rpResult = new RestTemplate().postForObject(url, rs, Map.class);
		System.out.println(rpResult);
	}
	
	public static void main(String[] args) {
		login();
		//logout();
	}
	
}
