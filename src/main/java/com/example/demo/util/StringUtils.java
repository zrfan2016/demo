package com.example.demo.util;

import java.util.Objects;

/**
 * @author zengruif
 * @className StringUtils
 * @description TODO
 * @date 2018/11/30 21:19
 **/
public class StringUtils {

    public static String concat2String(String... ars) {
        if (Objects.isNull(ars) || ars.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ars.length; i++) {
            stringBuilder.append(ars[i]);
        }
        return stringBuilder.toString();
    }

}
