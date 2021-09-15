package com.jzjr.response_resultoperation.Interceptor;

import com.jzjr.response_resultoperation.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class ResultResponseInterceptor implements HandlerInterceptor {
    private static final String RESULT_RESPONSE_ANN = "result_response_ann";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> beanType = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            //判断是否在类对象上添加注解
            if (beanType.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESULT_RESPONSE_ANN, beanType.getAnnotation(ResponseResult.class));
            }
            //判断是否在丰富上添加注解
            if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(RESULT_RESPONSE_ANN, method.getAnnotation(ResponseResult.class));
                Object attribute = request.getAttribute(RESULT_RESPONSE_ANN);
                System.out.println(attribute);
            }
        }
        return true;
    }
}
