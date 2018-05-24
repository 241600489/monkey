package com.zym.monkey.proxy;

import com.zym.monkey.monkeycore.message.ResponseMessage;
import com.zym.monkey.monkeyutil.JsonUtil;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author 梁自强
 * @date 2018/5/22 14:35
 * @desc
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String getDemo(FullHttpRequest request, ResponseMessage responseMessage) {

        return JsonUtil.toJsonString(request);
    }

}
