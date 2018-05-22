package com.zym.monkey.monkeycore.netty;

import com.zym.monkey.monkeycore.message.ResponseMessage;
import com.zym.monkey.monkeyutil.JsonUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * @author 梁自强
 * @date 2018/5/21 15:07
 * @desc 接收http类型的客户端请请求，通过不同的组件进行处理
 * ‘组件可以根据Order 关键字判定执行的顺序’
 */
public class HttpEntranceHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final Logger logger = LoggerFactory.getLogger(HttpEntranceHandler.class);
    public static final String CRLF = "\r\n";

    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        if (!req.decoderResult().isSuccess()) {
            logger.error("请求报文解码失败，头信息：{}", req.headers().toString());
            sendError(ctx, HttpResponseStatus.BAD_REQUEST);
        }

    }
    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setStatus(status.code());
        responseMessage.setMessage("请求报文解码失败");

        FullHttpResponse response =
                new DefaultFullHttpResponse(HTTP_1_1,
                        status,
                        Unpooled.copiedBuffer(JsonUtil.toJsonString(responseMessage) + CRLF,
                                CharsetUtil.UTF_8));
        response.headers().set(CONTENT_TYPE,"application/json;charset=UTF-8");
        ctx.writeAndFlush(response)
                .addListener(ChannelFutureListener.CLOSE);
    }
}
