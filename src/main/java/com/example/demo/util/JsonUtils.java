package com.example.demo.util;

import com.example.demo.vo.BaseRequestVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zengruif
 * @className JsonUtils
 * @description TODO
 * @date 2018/12/14 20:16
 **/
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(BaseRequestVo.class);

    public static String object2Json(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("JsonUtils.object2Json exception:{}", e);
            return null;
        }
    }

    public static <T> T json2Object(String json, Class<T> clz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return (T) mapper.readValue(json, clz);
        } catch (IOException e) {
            logger.error("json2Object exception:{}", e);
            
            return null;
        }
    }

}
