package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.message.ResponseMessage;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 梁自强
 * @date 2018/5/22 14:34
 * @desc
 */
public interface DemoService {
    String getDemo(FullHttpRequest request, ResponseMessage responseMessage);



}
