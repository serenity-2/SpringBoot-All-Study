package com.jzjr.response_resultoperation.comfig;

import com.jzjr.response_resultoperation.Interceptor.ResultResponseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
  public ResultResponseInterceptor getResultResponseInterceptor() {
        return new ResultResponseInterceptor();
  }

    public void addInterceptors(InterceptorRegistry registry) {
        //默认拦截所有
        registry.addInterceptor(getResultResponseInterceptor());
    }
}
