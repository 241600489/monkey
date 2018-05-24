package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.Interceptor;
import com.zym.monkey.monkeycore.intercep.InterceptorChain;
import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;
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
        chain.addInterceptor("tokenVerify", new TokenInterceptor());
        DemoService target = new DemoServiceImpl();
        List<Interceptor> interceptors = chain.interceptors();
        MonkeyHandler myHandler = new MonkeyHandler(target, interceptors);
        DemoService proxy = (DemoService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                target.getClass().getInterfaces(), myHandler);
        proxy.getDemo(new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, "/api"), new ResponseMessage());
    }

}
