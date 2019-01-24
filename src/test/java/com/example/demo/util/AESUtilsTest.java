package com.example.demo.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class AESUtilsTest {

    private static Logger logger = LoggerFactory.getLogger(AESUtilsTest.class);

    @Test
    public void testAES() {
        String key = "121221121";
        String signKey = "12345678";
        String data = "phone=13012345678&card=2221212121121211&product=AY";
        String sign = SignUtils.sign(data, signKey);
        logger.info(sign);
        StringBuilder sb = new StringBuilder();
        sb.append(data).append("&sign=").append(sign);
        String content = AESUtils.encode(sb.toString(), key);
        logger.info(content);
        assert !StringUtils.isEmpty(content);

        String decodeData = AESUtils.decode(content, key);

        logger.info("decodeData:{}", decodeData);
//        logger.info("{}", decodeData.equals(sb.toString()));
    }

    @Test
    public void testEncodeData() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("name", "121");
        data.put("pass", "2317361718");
        String key = "9526078ed2508f61";

        String signKey = "12345678";

        String str = AESUtils.encodeData(data, key, signKey);

        logger.info("data:{},encodeData:{}", data, str);

        String originalData = AESUtils.decode(str, key);

        logger.info("originalData:{}", originalData);

    }

}