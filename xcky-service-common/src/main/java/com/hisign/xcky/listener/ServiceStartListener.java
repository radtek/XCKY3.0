package com.hisign.xcky.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.hisign.xcky.api.service.IKafkaReceiveService;
import com.hisign.xcky.constant.Constants;

/**
 * 项目启动初始化类
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com.cn
 * 2016年11月26日
 */
@Service
public class ServiceStartListener implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private IKafkaReceiveService kafkaReceiveService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//初始化kafka消息接收监听
		//业务系统在使用消息接受时，需要使用
		//设置下系统唯一标识，因为默认消息分租会使用它作为分租标识的一部分（如果大家都用相同的标识，则只会往最新注册的那台机器发消息）
		//System.setProperty("SYSTEMID", Constants.SYSTEMID);
		//kafkaReceiveService.receiveMsg();
	}

}
