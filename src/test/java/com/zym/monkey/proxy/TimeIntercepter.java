package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.Interceptor;
import com.zym.monkey.monkeycore.intercep.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁自强
 * @date 2018/5/22 14:23
 * @desc
 */
public class TimeIntercepter implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(TimeIntercepter.class);
    @Override
    public Object intercept(MethodInvocation methodInvocation) {
        long t1 = System.currentTimeMillis();
        try {
            return methodInvocation.executeNext();
        } catch (Exception e) {
            logger.error("执行下一个任务失败，{}",e);
        } finally {
            System.out.println(System.currentTimeMillis() - t1);
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
