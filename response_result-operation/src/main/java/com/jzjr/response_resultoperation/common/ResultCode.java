package com.jzjr.response_resultoperation.common;

import lombok.Getter;

public enum ResultCode {
    SUCCESS(1,"成功"),
    ERROR(2,"失败");

    @Getter
    private Integer code;
    @Getter
    private String message;


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
