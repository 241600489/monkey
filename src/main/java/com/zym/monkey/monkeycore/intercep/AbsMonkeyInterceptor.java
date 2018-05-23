package com.zym.monkey.monkeycore.intercep;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 梁自强
 * @date 2018/5/22 16:26
 * @desc
 */
public class AbsMonkeyInterceptor implements Interceptor{
    @Override
    public Object intercept(MethodInvocation methodInvocation) {
        Object[] parameters = methodInvocation.getParameters();
        interceptBefore((FullHttpRequest)parameters[0]);
        return null;
    }

    public void interceptBefore(FullHttpRequest request) {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
