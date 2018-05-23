package com.zym.monkey.monkeycore.intercep;

import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 梁自强
 * @date 2018/5/22 10:00
 * @desc 拦截器类 、
 * 本网关会实现1. 验证与本网关的api规范 拦截器
 *          2. 权限验证的拦截器
 *          3. 日志处理拦截器
 */
public interface Interceptor {
    Object intercept(MethodInvocation methodInvocation);
    /**
     * 方法执行之前，拦截执行
     * @param request 请求
     */
    public void interceptBefore(FullHttpRequest request);

    /**
     * 方法执行完成之后 拦截执行
     * @param request 请求
     * @param responseMessage 返回的响应信息
     */
    public void interceptAfter(FullHttpRequest request, ResponseMessage responseMessage);
    int getOrder();
}
