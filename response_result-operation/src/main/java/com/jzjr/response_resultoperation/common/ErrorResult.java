package com.jzjr.response_resultoperation.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResult {
    private Integer code;

    private String errorMsg;

    private Object data;
}
