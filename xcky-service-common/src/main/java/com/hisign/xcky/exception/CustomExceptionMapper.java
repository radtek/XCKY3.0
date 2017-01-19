package com.hisign.xcky.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hisign.xcky.util.JsonResultUtil;

/**
 * 统一异常处理
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年11月5日
 */
public class CustomExceptionMapper implements ExceptionMapper<Exception> {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public Response toResponse(Exception exception) {
		
		boolean flag=true;
		String msg="服务器异常";
		//处理option methor试探异常
		if("No resource method found for options, return OK with Allow header".equals(exception.getMessage())){
			flag=false;
			msg="OPTION";
		}else if("No resource method found for POST, return 405 with Allow header".equals(exception.getMessage())){
			flag=false;
			msg="路径错误，请检查后再访问！";
		}
		if(flag){
			logger.error("异常", exception);
		}
		return Response.status(Status.OK).header("Status", Status.OK).entity(JsonResultUtil.error(exception.getMessage()))
				.type(MediaType.APPLICATION_JSON).build();
	}

}
