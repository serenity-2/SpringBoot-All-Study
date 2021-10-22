package com.jzjr.openfeignoperation.controller;

import com.alibaba.fastjson.JSON;
import com.jzjr.openfeignoperation.entity.SysUser;
import com.jzjr.openfeignoperation.entity.User;
import com.jzjr.openfeignoperation.service.UserServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private UserServiceFeignClient userServiceFeignClient;

    @GetMapping("/userinfo/{id}")
    public String getUserInfo(@PathVariable("id") Integer id) {
        User user = userServiceFeignClient.getUserInfo(id);
        return JSON.toJSONString(user);
    }

    @PostMapping("/save/user")
    public String saveUser(@RequestBody SysUser user) {
        System.out.println(user);
        return userServiceFeignClient.saveUser(user);
    }

    @GetMapping("/update/user")
    public String saveUser(@RequestParam("userName") String userName,@RequestParam("comment") String comment) {
        System.out.println(userName+"*****"+comment);
        Map<String, Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("comment",comment);
        return userServiceFeignClient.updateUser(map);
    }
}
