package com.hisign.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 服务层集成测试基类
 * @Author wangping
 * @Date 2016/8/4 9:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-application.xml", "classpath:test-mybatis.xml", "classpath:test-spring-ehcache.xml"})
public class ServiceIntegrationBaseTest {
    @Test
    public void test() {

    }
}
