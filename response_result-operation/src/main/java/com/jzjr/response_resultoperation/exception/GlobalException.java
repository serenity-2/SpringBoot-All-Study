package com.jzjr.response_resultoperation.exception;

import com.jzjr.response_resultoperation.common.ErrorResult;
import com.jzjr.response_resultoperation.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public ErrorResult handleException(Exception e){
        log.error(e.getMessage(), e);
        return new ErrorResult(ResultCode.ERROR.getCode(), ResultCode.ERROR.getMessage(),e.getMessage());
    }
}
