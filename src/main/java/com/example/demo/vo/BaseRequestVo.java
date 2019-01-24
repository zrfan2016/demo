package com.example.demo.vo;

import com.example.demo.signservice.SignService;
import com.example.demo.util.JsonUtils;
import com.example.demo.util.SignUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * @author zengruif
 * @className BaseRequestVo
 * @description TODO
 * @date 2018/12/14 20:01
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequestVo implements java.io.Serializable, SignService<Map<String, Object>> {

    private Map<String, Object> dataMap;
    private String sign;
    @JsonIgnore
    private transient String key;

    public BaseRequestVo(Map<String, Object> dataMap, String key) {
        this.dataMap = dataMap;
        this.key = key;
        this.sign = sign(dataMap, key);
    }

    @Override
    public String sign(Map<String, Object> stringObjectMap, String key) {
        return SignUtils.sign(JsonUtils.object2Json(stringObjectMap), key);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseRequestVo{");
        sb.append("dataMap=").append(dataMap);
        sb.append(", sign='").append(sign).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Map<String, Object> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, Object> dataMap) {
        this.dataMap = dataMap;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
