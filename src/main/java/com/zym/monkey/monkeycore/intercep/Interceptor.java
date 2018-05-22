package com.zym.monkey.monkeycore.intercep;

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

    int getOrder();
}
