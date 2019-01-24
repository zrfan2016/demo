package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author zengruif
 * @className SignUtils
 * @description TODO
 * @date 2018/11/30 19:17
 **/
public class SignUtils {

    private static Logger logger = LoggerFactory.getLogger(SignUtils.class);

    public static String sign(String data, String key) {
        return byte2Hex(encryptHMAC(data, key));
    }

    public static byte[] encryptHMAC(String data, String key) {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes("UTF-8"));
        } catch (Exception e) {
            logger.error("encryptHMAC exception:{}", e);
        }
        return bytes;
    }

    public static String byte2Hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
