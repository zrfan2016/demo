package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author zengruif
 * @className StrMapUtils
 * @description TODO
 * @date 2018/12/13 11:59
 **/
public class StrMapUtils {

    public static String concat2String(Map<String, String> requestData) {
        if (Objects.isNull(requestData) || requestData.isEmpty()) {
            return "";
        }
        Set<String> keySet = requestData.keySet();
        String[] keys = new String[keySet.size()];
        keySet.toArray(keys);
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            data.append(keys[i]).append("=").append(requestData.get(keys[i]));
            if (i != keys.length - 1) {
                data.append("&");
            }
        }
        return data.toString();
    }

    public static Map<String, String> decodeData2Map(String decodeData) {
        Map<String, String> reqData = new HashMap<>();
        if (org.springframework.util.StringUtils.isEmpty(decodeData)) {
            return reqData;
        }
        String[] ars = decodeData.split("&");
        if (Objects.nonNull(ars) && ars.length > 0) {
            for (int i = 0; i < ars.length; i++) {
                String[] data = ars[i].split("=");
                if (Objects.nonNull(data) && data.length == 2) {
                    reqData.put(data[0], data[1]);
                }
            }
        }
        return reqData;
    }
}
