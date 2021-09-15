package com.jzjr.response_resultoperation.advice;

import com.jzjr.response_resultoperation.annotation.ResponseResult;
import com.jzjr.response_resultoperation.common.ErrorResult;
import com.jzjr.response_resultoperation.common.Result;
import com.jzjr.response_resultoperation.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    private static final String RESULT_RESPONSE_ANN = "result_response_ann";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求是否标记
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESULT_RESPONSE_ANN);
        return responseResult != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("开始封装返回数据");
        if (o instanceof ErrorResult) {
            // 返回值异常
            ErrorResult errorResult = (ErrorResult) o;
            return Result.error(errorResult.getCode(),errorResult.getErrorMsg(),errorResult.getData());
        }
        return Result.success(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),o);
    }
}
