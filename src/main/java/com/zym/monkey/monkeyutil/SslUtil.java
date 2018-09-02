package com.zym.monkey.monkeyutil;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyStore;

import static javax.net.ssl.KeyManagerFactory.getDefaultAlgorithm;

/**
 * @Author unyielding
 * @date 2018/9/2 0002 13:44
 * @desc
 */
public class SslUtil {
    public static SSLContext createSslContext
            (String type, String path, String password) throws Exception {
        KeyStore ks = KeyStore.getInstance(type);
        FileInputStream ksInputStream = new FileInputStream(path);
        ks.load(ksInputStream, password.toCharArray());
        //KeyManagerFactory充当基于密钥内容源的密钥管理器的工厂
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(getDefaultAlgorithm());//getDefaultAlgorithm:获取默认的 KeyManagerFactory 算法名称。
        kmf.init(ks, password.toCharArray());
        //SSLContext的实例表示安全套接字协议的实现，它充当用于安全套接字工厂或 SSLEngine 的工厂。
        SSLContext sslContext = SSLContext.getInstance("TLSv1");

        sslContext.init(kmf.getKeyManagers(), null, null);
        return sslContext;
    }
}
