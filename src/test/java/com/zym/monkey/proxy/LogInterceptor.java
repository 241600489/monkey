package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.Interceptor;
import com.zym.monkey.monkeycore.intercep.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁自强
 * @date 2018/5/22 15:25
 * @desc log 拦截器
 */
public class LogInterceptor implements Interceptor {
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);

    @Override
    public Object intercept(MethodInvocation methodInvocation) {
        Object result = null;
        try {
            result= methodInvocation.executeNext();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (result != null) {
                log.info((String)result);
            }
        }
        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
