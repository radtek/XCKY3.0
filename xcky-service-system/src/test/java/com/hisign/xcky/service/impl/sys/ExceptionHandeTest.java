package com.hisign.xcky.service.impl.sys;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hisign.BaseUnit4Test;
import com.hisign.sso.api.rest.entity.sys.User;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.sso.api.service.sys.UserService;

/**  
 * @类功能说明：   异常捕获的测试类
 * @作者：hotdog  
 * @创建时间：2016-11-8 下午3:40:27  
 */ 
public class ExceptionHandeTest extends BaseUnit4Test {

	/**
	 * sso 用户服务
	 */
	@Autowired
	private UserService ssoUserService;
	
	/* (non-Javadoc)
	 * @see com.hisign.BaseUnit4Test#testApp()
	 */
	@Override
	@Test
	public void testApp() {
		
		try {
			doTest();
		} catch (Exception e) {
			if (e instanceof RestBusinessException ) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
	
	private void doTest () throws Exception {
		User user = ssoUserService.getUserByUserId("12312313123");
		if (user == null)
			 System.out.println("result is null");
		else 
			 System.out.println(user.getAccount());
	}
}
