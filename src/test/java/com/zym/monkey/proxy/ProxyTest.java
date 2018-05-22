package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.DefaultMethodInvocation;
import com.zym.monkey.monkeycore.intercep.Interceptor;
import com.zym.monkey.monkeycore.intercep.InterceptorChain;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author 梁自强
 * @date 2018/5/22 9:50
 * @desc 测试代理
 */
public class ProxyTest  {
    @Test
    public void testgetInstance() {
        InterceptorChain chain = new InterceptorChain();
        chain.addInterceptor("time", new TimeIntercepter());
        chain.addInterceptor("log", new LogInterceptor());
        DemoService target = new DemoServiceImpl();
        List<Interceptor> interceptors = chain.interceptors();
        MyHandler myHandler = new MyHandler(target, interceptors);
        DemoService proxy = (DemoService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                target.getClass().getInterfaces(), myHandler);

        proxy.getDemo();
    }

}
