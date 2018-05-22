package com.zym.monkey.proxy;

import java.text.DecimalFormat;

/**
 * @author 梁自强
 * @date 2018/5/22 14:35
 * @desc
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String getDemo() {
        return "程序代理";
    }

}
