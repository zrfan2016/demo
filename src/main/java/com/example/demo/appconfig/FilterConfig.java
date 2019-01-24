package com.example.demo.appconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author zengruif
 * @className FilterConfig
 * @description TODO
 * @date 2018/11/30 17:08
 **/
@Configuration
public class FilterConfig {

    private static final Logger logger = LoggerFactory.getLogger(FilterConfig.class);

    @Bean
    public FilterRegistrationBean appFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new AppFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("AppFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    public class AppFilter implements Filter {
        @Override
        public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            logger.info("uri:{}", request.getRequestURI());
            logger.info("url:{}", request.getRequestURL());
            filterChain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }
    }
}
