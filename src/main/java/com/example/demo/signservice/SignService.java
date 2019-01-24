package com.example.demo.signservice;

/**
 * @author zengruif
 * @className SignService
 * @description TODO
 * @date 2018/12/14 20:07
 **/
public interface SignService<T> {

    /**
     * 生成签名
     *
     * @param t
     * @return
     */
    String sign(T t, String key);

}
