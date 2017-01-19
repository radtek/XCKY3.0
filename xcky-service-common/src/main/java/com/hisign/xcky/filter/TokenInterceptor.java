package com.hisign.xcky.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.container.spring.SpringContainer;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.sdk.common.Constant;
import com.hisign.sso.api.rest.filter.OutputStreamWrapper;
import com.hisign.xcky.api.model.system.SysLog;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.service.system.SysLogService;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * TOKEN检查的拦截器
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年11月4日
 */
@Priority(Priorities.USER)
public class TokenInterceptor implements ContainerRequestFilter, ContainerResponseFilter, ReaderInterceptor, WriterInterceptor{
	
	@Context
    private HttpServletRequest servletRequest;
	
	@Autowired
	private RedisClient redisClient;
	
	@Autowired
	private SysLogService sysLogService;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//System.out.println("rest拦截器");
		String url=servletRequest.getRequestURL().toString();
		if(!url.endsWith("login/login")){
			//如果不是登录，则需要验证token是否存在
			String token=requestContext.getHeaderString("token");
			boolean flag=false;
			String tokenTip="";
			if(token!=null&&!"".equals(token)){
				if(redisClient==null || sysLogService==null){
					redisClient=SpringContainer.getContext().getBean(RedisClient.class);
					sysLogService=SpringContainer.getContext().getBean(SysLogService.class);
				}
				SysUser sysUser=redisClient.getObj(token, SysUser.class);
				if(sysUser==null){
					flag=true;
					tokenTip="token失效！";
				}else{
					//开始记录操作日志
					byte[] buffer = IOUtils.toByteArray(requestContext.getEntityStream());
					String mediaType=requestContext.getMediaType().toString();
					//只有json请求才会保存操作日志；
					if(mediaType.startsWith("application/json")){
						String reqMsg = new String(buffer, Constant.CHARSET_NAME);
						url=url.substring(url.indexOf("/api"));
						//记录操作日志
						SysLog sysLog=new SysLog();
						sysLog.setOptTime(new Date());
						sysLog.setOptUser(sysUser.getTrueName());
						sysLog.setOptUserId(sysUser.getId());
						sysLog.setOptUserIp(servletRequest.getRemoteAddr());
						sysLog.setOptDesc(reqMsg);
						sysLog.setOptUrl(url);
						sysLogService.add(token, sysLog);
					}
					requestContext.setEntityStream(new ByteArrayInputStream(buffer));
				}
			}else{
				flag=true;
				tokenTip="没有token！";
			}
			//参数token没传过来或者后台redis中没有相应的token
			if(flag){
				Response response=Response.status(Status.OK).header("Status", "200").entity(JsonResultUtil.authentFail(tokenTip)).type(MediaType.APPLICATION_JSON).build();
				requestContext.abortWith(response);
				return;
			}
		}
	}

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		OutputStreamWrapper wrapper = new OutputStreamWrapper(context.getOutputStream());
		context.setOutputStream(wrapper);
		context.proceed();
	}

	//貌似只有body有数据才会走这个方法
	@Override
	public Object aroundReadFrom(ReaderInterceptorContext readerInterceptorContext) throws IOException, WebApplicationException {
		byte[] buffer = IOUtils.toByteArray(readerInterceptorContext.getInputStream());
		readerInterceptorContext.setInputStream(new ByteArrayInputStream(buffer));
		return readerInterceptorContext.proceed();
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Expose-Headers", "Status");
		headers.add("Access-Control-Allow-Headers", "X-Requested-With,Content-Type,token");
		headers.add("Access-Control-Allow-Methods", "POST,GET");
		headers.add("Access-Control-Max-Age", 3600 * 24);
	}
	
}
