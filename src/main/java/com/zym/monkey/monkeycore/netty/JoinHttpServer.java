package com.zym.monkey.monkeycore.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author 梁自强
 * @Date 2018/5/21 14:44
 * @desc 用netty 构建一个接入客户端请求的endpoint
 */
public class JoinHttpServer {
    public void startHttp(String ip, int port, int threadNum, int soBackLog) {

        EventLoopGroup bossGroop = new NioEventLoopGroup(threadNum);
        EventLoopGroup workerGroup = new NioEventLoopGroup(threadNum);

        ServerBootstrap b = new ServerBootstrap();
        try {
        b.group(bossGroop, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, soBackLog)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                        ch.pipeline().addLast("http-encoder", new HttpObjectAggregator(65536));
                        ch.pipeline().addLast("http-resencoder", new HttpResponseEncoder());
                        ch.pipeline().addLast("api-handler-entrance", new HttpEntranceHandler());
                    }
                });

            ChannelFuture f = b.bind(ip, port).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            /*优雅关闭*/
            bossGroop.shutdownGracefully();
            bossGroop.shutdownGracefully();

        }

    }

    public static void main(String[] args) {
        new JoinHttpServer().startHttp("127.0.0.1", 8080, 20, 1024);
    }
}
