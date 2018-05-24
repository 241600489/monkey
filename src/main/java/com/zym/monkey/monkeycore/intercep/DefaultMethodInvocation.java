package com.zym.monkey.monkeycore.intercep;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author 梁自强
 * @date 2018/5/22 12:54
 * @desc 默认的方法调用类
 */
public  class DefaultMethodInvocation implements MethodInvocation {
    //目标类 要被代理的
    private Object target;
    //代理 额外做的事
    private Object proxy;

    private Method method;
    private Object[] parameters;
    //拦截器链
    private List<Interceptor> interceptors;

    //当前拦截器链索引值，初始值：-1，范围：0-interceptors.size()-1
    private int currentIndex = -1;

    public DefaultMethodInvocation(Object target, Object proxy, Object[] parameters, List<Interceptor> interceptors,Method method) {
        this.target = target;
        this.proxy = proxy;
        this.parameters = parameters;
        this.interceptors = interceptors;
        this.method = method;
    }

    /**
     * 调用下一个拦截器
     * @return
     * @throws Exception
     */
    public Object executeNext() throws Exception{
        if (interceptors.size()-1 == currentIndex) {
            return method.invoke(this.target,parameters);
        }
        //获取下一个要执行的拦截器
        Interceptor interceptor = interceptors.get(++currentIndex);
        return  interceptor.intercept(this);
    }




    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        return proxy;
    }

    public void setProxy(Object proxy) {
        this.proxy = proxy;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
