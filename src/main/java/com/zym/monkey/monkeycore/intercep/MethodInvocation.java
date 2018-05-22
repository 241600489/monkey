package com.zym.monkey.monkeycore.intercep;

import java.lang.reflect.Method;

/**
 * @author 梁自强
 * @date 2018/5/22 12:04
 * @desc 方法调用
 */
public interface MethodInvocation {
     Object[] getParameters();

     Method getMethod();

    /**
     *  调用下一个拦截器
     * @return
     * @throws Exception
     */
    Object executeNext() throws Exception;

}
