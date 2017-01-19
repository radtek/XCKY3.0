package com.hisign.xcky.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.hisign.xcky.constant.Constants;

/**  
 * @类功能说明：   Rest客户端请求模板 工具类
 * @作者：hotdog  
 * @创建时间：2016-10-28 下午7:40:02  
 */ 
public class RestTemplateUtil {

	private static RestTemplate instance = null;
	
	private static HttpHeaders header = new HttpHeaders();
	
	static {
		instance = new RestTemplate();
	}
	
	private RestTemplateUtil () {
		
	}
	
	/**  
	 * 方法功能说明：  对外暴露RestTemplate单例
	 * 创建：2016-10-28 by hotdog   
	 * @参数： @return      
	 * @return RestTemplateUtil
	 */  
	public static RestTemplate getInstance () {
		if (instance == null) {
			return new RestTemplate();
		}
		return instance;
	}
	
	/**  
	 * 方法功能说明：  通用restAPI客户端调用方法
	 * 创建：2016-10-28 by hotdog 
	 * @参数： @param token   
	 * @参数： @param url资源路径
	 * @参数： @param body请求体
	 * @参数： @param headers请求头信息
	 * @参数： @param method请求方式
	 * @参数： @param responseType返回的响应类型
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return Object
	 */  
	public static Object invoke (String token, String url, Object body, Map<String, String> headers, 
			HttpMethod method, Class responseType) throws Exception{
		if(StringUtils.isEmpty(url) || method == null) {
			throw new Exception("Parameters of the url and method cannot be empty.");
		}
		
		String _body = "";
		if (body != null) {
			_body = JSON.toJSONString(body);
		}
		
		header.clear();
		if (!StringUtils.equals(token, "pubservice")) { //非登录操作
			header.add("systemId", Constants.SYSTEMID);
			header.add("token", token);
		}
		header.setContentType(MediaType.APPLICATION_JSON);
		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				header.add(entry.getKey(), entry.getValue());
			}
		}
		
		HttpEntity rs = new HttpEntity(_body, header);
		switch (method) {
		case POST:
			return instance.postForObject(url, rs, responseType);
		case GET:
			return instance.exchange(url, HttpMethod.GET, rs, responseType).getBody();
		default:
			break;
		}
		return null;
	}
}
