package com.zym.monkey.proxy;

import com.google.common.base.Preconditions;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.junit.Test;

/**
 * @author 梁自强
 * @date 2018/5/25 14:56
 * @desc
 */
public class GuavaTest {
    @Test
    public void testCheckNotNull() {
        String str = Preconditions.checkNotNull(new ObjectEncoder(), "interceptor： 要传入的对象不能为空").toString();

        System.out.println(str);


    }
}
