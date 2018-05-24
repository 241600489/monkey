package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.AbsMonkeyInterceptor;
import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁自强
 * @date 2018/5/22 14:23
 * @desc
 */
public class TimeIntercepter extends AbsMonkeyInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TimeIntercepter.class);
    private long t1=0l;
    @Override
    public void interceptBefore(FullHttpRequest request) {
        t1 = System.currentTimeMillis();
    }

    @Override
    public void interceptAfter(FullHttpRequest request, ResponseMessage responseMessage) {
        logger.info("所用时间" + (System.currentTimeMillis() - t1));
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
