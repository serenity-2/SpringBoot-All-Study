package com.example.springvalidation.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UserAddDTO {
    @NotEmpty(message = "用户账号不能为空")
    @Length(min = 5,max = 16,message = "账号长度为5~16位")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message ="账号格式为数字和字母" )
    private String username;

    @NotEmpty(message = "用户密码不能为空")
    @Length(min = 8,max = 20,message = "密码长度必须为8~20位")
    private String password;
}
