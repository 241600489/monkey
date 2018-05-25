package com.zym.monkey.monkeycore.intercep;

import com.google.common.base.Preconditions;
import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 梁自强
 * @date 2018/5/22 16:26
 * @desc
 */
public abstract class AbsMonkeyInterceptor implements Interceptor {
    @Override
    public Object intercept(MethodInvocation methodInvocation) {
        Object result = null;
        Object[] parameters = methodInvocation.getParameters();
        FullHttpRequest request = (FullHttpRequest) parameters[0];
        ResponseMessage responseMessage = (ResponseMessage) parameters[1];
        try {
            interceptBefore(request);
            result = methodInvocation.executeNext();
            interceptAfter(request, responseMessage);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public int compareTo(Interceptor interceptor) {
        interceptor=Preconditions.checkNotNull(interceptor, "interceptor： 要传入的对象不能为空");
        return this.getOrder() - interceptor.getOrder();
    }
}
