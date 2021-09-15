package com.jzjr.swaggeroperation.controller;

import com.jzjr.swaggeroperation.dto.UserAddDTO;
import com.jzjr.swaggeroperation.dto.UserUpdateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "用户api接口")  //@Api 注解，添加在 Controller 类上，标记它作为 Swagger 文档资源
public class UserController {
    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表", notes = "目前仅仅是作为测试，所以返回用户全列表")
    /**
     @ApiOperation 注解，添加在 Controller 方法上，标记它是一个 API 操作。
     value 属性：API 操作名。
     notes 属性：API 操作的描述
     */
    public List<User> list() {
        // 查询列表
        List<User> result = new ArrayList<>();
        result.add(new User().setId(1).setUserName("yudaoyuanma"));
        result.add(new User().setId(2).setUserName("woshiyutou"));
        result.add(new User().setId(3).setUserName("chifanshuijiao"));
        // 返回列表
        return result;
    }

    @GetMapping("/get")
    @ApiOperation("获得指定用户编号的用户")
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query", dataTypeClass = Integer.class, required = true, example = "1024")
    public User get(@RequestParam("id") Integer id) {
        // 查询并返回用户
        return new User().setId(id).setUserName(UUID.randomUUID().toString());
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Integer add(UserAddDTO addDTO) {
        // 插入用户记录，返回编号
        Integer returnId = UUID.randomUUID().hashCode();
        // 返回用户编号
        return returnId;
    }

    @PostMapping("/update")
    @ApiOperation("更新指定用户编号的用户")
    public Boolean update(UserUpdateDTO updateDTO) {
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除指定用户编号的用户")
    //@ApiImplicitParam 注解，添加在 Controller 方法上，声明每个请求参数的信息
    @ApiImplicitParam(name = "id", value = "用户编号", paramType = "query", dataTypeClass = Integer.class, required = true, example = "1024")
    public Boolean delete(@RequestParam("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }
}
