package com.jzjr.response_resultoperation.common;

import lombok.Data;

@Data
public class Result {

    private Integer code;

    private String message;

    public Object data;

    public Result() {

    }

    public Result(ResultCode resultCode,Object data) {
     this.code = resultCode.getCode();
     this.message = resultCode.getMessage();
     this.data = data;
    }
    public static Result success(Integer code,String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result success(Integer code,String message,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public static Result error(Integer code,String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result error(Integer code,String message,Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
