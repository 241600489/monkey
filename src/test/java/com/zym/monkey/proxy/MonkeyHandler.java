package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.DefaultMethodInvocation;
import com.zym.monkey.monkeycore.intercep.Interceptor;
import com.zym.monkey.monkeycore.intercep.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 梁自强
 * @date 2018/5/22 15:11
 * @desc
 */
public class MonkeyHandler implements InvocationHandler {
    private Object target;
    private List<Interceptor> list;

    public MonkeyHandler(Object target, List<Interceptor> list) {
        this.target = target;
        this.list = list;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInvocation invocation = new DefaultMethodInvocation(this.target, proxy, args, this.list, method);
        return invocation.executeNext();
    }
}
