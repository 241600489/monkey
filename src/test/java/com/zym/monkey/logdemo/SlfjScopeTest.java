package com.zym.monkey.logdemo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁自强
 * @date 2018/5/21 15:41
 * @desc 测试slfj与log4j 默认绑定的scope 是test
 */
public class SlfjScopeTest {
    static Logger logger = LoggerFactory.getLogger(SlfjScopeTest.class);
    @Test
    public void testLogInfo() {
        logger.info("测试成功");
        logger.debug("debug 成功");

        new Thread(()->{
            System.out.println("你好");
        });

    }

    public static void main(String[] args) {
        logger.info("测试失败");

    }
}
