package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Map;

/**
 * @author zengruif
 * @className AESUtils
 * @description TODO
 * @date 2018/11/30 18:35
 **/
public class AESUtils {

    private static Logger logger = LoggerFactory.getLogger(AESUtils.class);

    public static String encodeData(Map<String, String> requestData, String key, String signKey) {
        requestData.put("sign", SignUtils.sign(StrMapUtils.concat2String(requestData), signKey));
        return encode(StrMapUtils.concat2String(requestData), key);
    }


    public static String encode(String data, String key) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(key.getBytes()));
            SecretKey original_key = keyGenerator.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKey secretKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteEncode = data.getBytes("UTF-8");
            byte[] byteAES = cipher.doFinal(byteEncode);
            return new String(new BASE64Encoder().encode(byteAES));
        } catch (Exception e) {
            logger.info("e:{}", e);
            return null;
        }
    }

    public static String decode(String content, String key) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(key.getBytes()));
            SecretKey originalKey = keyGenerator.generateKey();
            byte[] raw = originalKey.getEncoded();
            SecretKey secretKey = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] byteContent = new BASE64Decoder().decodeBuffer(content);

            byte[] byteDecode = cipher.doFinal(byteContent);
            return new String(byteDecode, "UTF-8");
        } catch (Exception e) {
            logger.error("e:{}", e);
            return null;
        }
    }
}
