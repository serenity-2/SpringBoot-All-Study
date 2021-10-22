package com.jzjr.openfeignoperation.config;

import com.jzjr.openfeignoperation.service.UserServiceFeignClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public UserServiceFeignClient userServiceFeignClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(UserServiceFeignClient.class,"http://127.0.0.1:8088");
    }
}
