package com.jzjr.swaggeroperation.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@ApiModel("新增用户参数")
//必须要有get/set方法
@Data
public class UserAddDTO {
    @ApiModelProperty(value = "用户id", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "爱好", required = true)
    private List<String> hobbies;
}
