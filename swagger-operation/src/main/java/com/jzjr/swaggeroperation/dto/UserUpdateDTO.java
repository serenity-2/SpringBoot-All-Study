package com.jzjr.swaggeroperation.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("新增用户参数")
@Data
public class UserUpdateDTO {
    @ApiModelProperty(value = "用户id", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
}
