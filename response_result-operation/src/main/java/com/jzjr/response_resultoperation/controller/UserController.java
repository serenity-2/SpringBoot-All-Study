package com.jzjr.response_resultoperation.controller;

import com.jzjr.response_resultoperation.annotation.ResponseResult;
import com.jzjr.response_resultoperation.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get/{id}")
    @ResponseResult
    public User getUser(@PathVariable("id") String id) {
        int i = 1 / 0;
        return new User().setId("1")
                        .setUserName("Daisy");
    }

}
