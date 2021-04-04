package com.standard.conf;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class FeignConfigure {
    public static int connectTimeOutMillis = 12000;//超时时间
    public static int readTimeOutMillis = 12000;
    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }


    //自定义重试次数 3次
    @Bean
    public Retryer feignRetryer(){
        Retryer retryer = new Retryer.Default(100, 1000, 3);
        return retryer;
    }
}
