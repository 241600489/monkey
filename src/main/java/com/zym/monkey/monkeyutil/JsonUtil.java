package com.zym.monkey.monkeyutil;

import com.google.gson.Gson;

/**
 * @author 梁自强
 * @date 2018/5/21 16:45
 * @desc json 转换 工具类 封装成为静态方法好可以有效的调用
 */
public class JsonUtil {
    private static Gson gson = new Gson();
    public static String toJsonString(Object obj) {
       return new Gson().toJson(obj);
    }

}
