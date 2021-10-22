package com.jzjr.mybatisoperating.service.impl;

import com.jzjr.mybatisoperating.entity.SysUser;
import com.jzjr.mybatisoperating.entity.User;
import com.jzjr.mybatisoperating.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User selectUserById(Integer id) {
        System.out.println("select user . . . . . . ");
        return new User().setUserId(1)
                .setUserName("julia")
                .setComments("hello,i'am julia.");
    }

    @Override
    public void saveUser(SysUser user) {
        System.out.println("save user . . . . . . ");
    }

    @Override
    public void updateUser(String userName, String comment) {
        System.out.println(userName+"******"+comment);
        System.out.println("update user success . . . . . . ");
    }
}
