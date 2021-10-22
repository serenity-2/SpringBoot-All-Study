package com.jzjr.mybatisoperating.service;

import com.jzjr.mybatisoperating.entity.SysUser;
import com.jzjr.mybatisoperating.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {
    User selectUserById(Integer id);

    void saveUser(SysUser user);

    void updateUser(String userName, String comment);
}
