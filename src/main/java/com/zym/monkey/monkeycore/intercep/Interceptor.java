package com.zym.monkey.monkeycore.intercep;


import com.sun.istack.internal.NotNull;
import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 梁自强
 * @date 2018/5/22 10:00
 * @desc 拦截器类
 * 本网关会实现1. 验证与本网关的api规范的拦截器
 *          2. 权限验证的拦截器
 *          3. 日志处理拦截器
 */
public interface Interceptor extends Comparable<Interceptor>{

    /**
     * 方法执行
     * @param methodInvocation 默认传入方法调用
     * @return 返回方法执行的结果
     */
    Object intercept(@NotNull MethodInvocation methodInvocation);
    /**
     * 方法执行之前，拦截执行
     * @param request 请求
     */
    public void interceptBefore(@NotNull FullHttpRequest request);

    /**
     * 方法执行完成之后 拦截执行
     * @param request 请求
     * @param responseMessage 方法调用返回的响应信息
     */
    public void interceptAfter(@NotNull FullHttpRequest request, @NotNull ResponseMessage responseMessage);

    /**
     * 拦截器的顺序，程序执行会按照这个顺序
     * @return 返回拦截器的顺序
     */
    int getOrder();
}
