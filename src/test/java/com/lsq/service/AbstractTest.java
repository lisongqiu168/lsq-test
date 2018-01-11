package com.lsq.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", })
public abstract class AbstractTest extends AbstractJUnit4SpringContextTests {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 根据类型获取bean
     * 
     * @param clazz bean类型
     * @return bean
     * @see ApplicationContext#getBean(Class)
     */
    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

}