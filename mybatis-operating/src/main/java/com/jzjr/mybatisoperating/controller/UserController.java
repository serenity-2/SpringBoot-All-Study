package com.jzjr.mybatisoperating.controller;

import com.alibaba.fastjson.JSON;
import com.jzjr.mybatisoperating.entity.SysUser;
import com.jzjr.mybatisoperating.entity.User;
import com.jzjr.mybatisoperating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public String getUserInfo(@PathVariable("id") Integer id) {
        User user = userService.selectUserById(2);
        return JSON.toJSONString(user);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody SysUser user) throws InterruptedException {
//        userService.saveUser(user);
        Thread.sleep(5000);
        return "save user success";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("userName") String userName,@RequestParam("comment") String comment) {
        userService.updateUser(userName,comment);
        return "update user success";
    }
}
