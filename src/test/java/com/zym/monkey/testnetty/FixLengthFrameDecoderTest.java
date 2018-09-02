package com.zym.monkey.testnetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Author 梁自强
 * @date 2018/6/10 0010 21:33
 * @desc  netty 单元化测试
 */
public class FixLengthFrameDecoderTest {
    @Test
    public void testFramesDecode() {
        ByteBuf buf =
                Unpooled.buffer(9);
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        ByteBuf input =
                Unpooled.buffer(9);
        for (int i = 0; i < 9; i++) {
            input.writeByte(i);
        }


//        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel =
                new EmbeddedChannel(new FixLengthFrameDecoder(3));


        Assert.assertTrue(channel.writeInbound(input));

        Assert.assertTrue(channel.finish());

        Assert.assertEquals(buf.readBytes(3), channel.readInbound());
        Assert.assertEquals(buf.readBytes(3), channel.readInbound());
        Assert.assertEquals(buf.readBytes(3), channel.readInbound());
        Assert.assertNull(channel.readInbound());

    }
}
