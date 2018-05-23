package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.intercep.AbsMonkeyInterceptor;
import com.zym.monkey.monkeyutil.JsonUtil;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 梁自强
 * @date 2018/5/22 16:49
 * @desc
 */
public class TokenInterceptor extends AbsMonkeyInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);
    public void interceptBefore(FullHttpRequest request) {
        log.info(request.toString());
    }

}
