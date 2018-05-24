package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.AbsMonkeyInterceptor;
import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁自强
 * @date 2018/5/22 15:25
 * @desc log 拦截器
 */
public class LogInterceptor extends AbsMonkeyInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.class);

    private long t1=0l;


    @Override
    public void interceptBefore(FullHttpRequest request) {
        log.info("请求信息：" + request.toString());
    }

    @Override
    public void interceptAfter(FullHttpRequest request, ResponseMessage responseMessage) {
        log.info("返回信息" + responseMessage.toString());

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
