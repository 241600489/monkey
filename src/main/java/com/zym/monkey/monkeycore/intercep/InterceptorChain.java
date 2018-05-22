package com.zym.monkey.monkeycore.intercep;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 梁自强
 * @date 2018/5/22 14:05
 * @desc
 */
public class InterceptorChain {
    //由于这是个有状态的，所以采用ConcurrentHashMap 做并发控制
    private Map<String, Interceptor> interceptorMap = new ConcurrentHashMap<>();



    public void addInterceptor(String name,Interceptor interceptor) {
        this.interceptorMap.put(name, interceptor);
    }

    public Interceptor removeInterceptor(String name) {
        return this.interceptorMap.remove(name);
    }
    public List<Interceptor> interceptors(){
        return new ArrayList<Interceptor>(this.interceptorMap.values());
    }

}
