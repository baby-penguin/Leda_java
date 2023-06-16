package com.demo.htanswer.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//全局配置类
@Configuration
public class WebConfigure implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*跨域内容
        1. 访问路径
        2. 请求来源
        3. 方法
        4，允许携带
        5. 响应时间
        * */
        registry.addMapping("/**")
                .allowedOrigins("Http://localhost:8080","null")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
