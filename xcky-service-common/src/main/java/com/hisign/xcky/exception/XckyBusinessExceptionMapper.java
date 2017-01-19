package com.hisign.xcky.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.util.JsonResultUtil;

/**  
 * @类功能说明：   自定义业务异常处理方式
 * @作者：hotdog  
 * @创建时间：2016-11-8 下午2:14:54  
 */ 
public class XckyBusinessExceptionMapper implements ExceptionMapper<RestBusinessException>{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public Response toResponse(RestBusinessException exception) {
		logger.error("异常", exception);
		return Response.status(Status.OK).header("Status", Status.OK).entity(JsonResultUtil.error(exception.getMessage()))
				.type(MediaType.APPLICATION_JSON).build();
	}

}
