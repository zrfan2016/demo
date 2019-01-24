package com.example.demo.controller;

import com.example.demo.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zengruif
 * @className HelloController
 * @description TODO
 * @date 2018/11/30 16:45
 **/
@RestController
@RequestMapping("/hello/")
public class HelloController {

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    {
        logger.info("HelloController init");
    }

    @RequestMapping("${name}")
    public String sayHello(HttpServletRequest request, HttpServletResponse response, String name) {
        Map<String, String[]> map = (Map<String, String[]>) request.getParameterMap();

        map.forEach((k, v) -> logger.info("key:{},value:{}", k, v));

        return StringUtils.concat2String("hello ", name);
    }
}
