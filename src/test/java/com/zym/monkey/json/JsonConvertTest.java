package com.zym.monkey.json;

import com.zym.monkey.monkeycore.message.MonkeyErrorMsg;
import com.zym.monkey.monkeycore.message.ResponseMessage;
import com.zym.monkey.monkeyutil.JsonUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 梁自强
 * @date 2018/5/21 16:48
 * @desc 测试JsonUtil 工具类
 */
public class JsonConvertTest {
    @Test
    public void toJsonTest() {
        final ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("nihao");
        responseMessage.setStatus(200);
        responseMessage.setErrorMsg(new MonkeyErrorMsg());
        Map<String, Object> data = new HashMap<>();
        data.put("key", "value");
        responseMessage.setData(data);
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(()->{
            System.out.println(10);

        });

//        for (int i = 0; i < 5; i++) {
            service.execute(()->{
                String str = JsonUtil.toJsonString(responseMessage);
                System.out.println(str);

            });
//        }
    }
}
