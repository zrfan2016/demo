package com.example.demo.util;

import com.example.demo.vo.BaseRequestVo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class SignUtilsTest {

    private static Logger logger = LoggerFactory.getLogger(SignUtilsTest.class);

    @Test
    public void testSign() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("pwd", "123456");
        String key = "12345678";
        BaseRequestVo vo = new BaseRequestVo(map, key);
        logger.info("vo:{}", vo);

        String aesKey = "1234567890";
        String reqData = AESUtils.encode(JsonUtils.object2Json(vo), aesKey);

        logger.info("reqData:{}", reqData);

        String jsonData = AESUtils.decode(reqData, aesKey);
        logger.info("jsonData:{}", jsonData);
        BaseRequestVo requestVo = JsonUtils.json2Object(jsonData, BaseRequestVo.class);
//        assert requestVo != null;

        logger.info("validateSign:{}", requestVo.getSign().equals(SignUtils.sign(JsonUtils.object2Json(requestVo.getDataMap()), key)));

    }


}