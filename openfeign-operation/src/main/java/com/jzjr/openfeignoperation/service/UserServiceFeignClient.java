package com.jzjr.openfeignoperation.service;

import com.jzjr.openfeignoperation.entity.SysUser;
import com.jzjr.openfeignoperation.entity.User;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UserServiceFeignClient {
    //根据id查询用户
    @RequestLine("GET /user/get/{id}")
    User getUserInfo(@Param("id") Integer id);

    @RequestLine("POST /user/save")
    @Headers("Content-Type: application/json")
    String saveUser(SysUser user);

    @RequestLine("GET /user/update")
    String updateUser(@QueryMap Map<String,Object> queryMap);
}
