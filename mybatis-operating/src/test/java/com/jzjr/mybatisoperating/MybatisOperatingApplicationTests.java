package com.jzjr.mybatisoperating;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jzjr.mybatisoperating.entity.ConfProperties;
import com.jzjr.mybatisoperating.entity.SysUser;
import com.jzjr.mybatisoperating.entity.User;
import com.jzjr.mybatisoperating.mapper.ConfigPropertiesMapper;
import com.jzjr.mybatisoperating.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisOperatingApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ConfigPropertiesMapper configPropertiesMapper;

    @Test
    void contextLoads() {
    }

//    @Test
//    public void selectCount() {
//        SysUser sysUser = new SysUser();
//        sysUser.setUserName("lili");
//        int i = userMapper.selectCount(sysUser);
//        System.out.println(i);
//    }

//    @Test
//    public void fenyeMysql(){
//        PageInfo<Object> pageInfo = PageHelper.startPage(1, 10).
//                setOrderBy("user_id desc").
//                doSelectPageInfo(() -> this.userMapper.selectAll());
//        System.out.println(pageInfo);
//    }

//    @Test
//    public void fenyeOracle(){
//        QueryWrapper<ConfProperties> queryWrapper = new QueryWrapper<>();
//        PageInfo<Object> pageInfo = PageHelper.startPage(1, 10)
//                .setOrderBy("PID DESC")
//                .doSelectPageInfo(() -> this.configPropertiesMapper.selectList(queryWrapper));
//        System.out.println(pageInfo);
//    }

    @Test
    public void fenyeIPage(){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        IPage<SysUser> page = new Page<SysUser>(1, 5);
        IPage<SysUser> iPage = this.userMapper.selectPage(page,queryWrapper);
        //当前页
        System.out.println(iPage.getCurrent());
        //每页大小
        System.out.println(iPage.getSize());
        //查询记录
        System.out.println(iPage.getRecords());
    }
}
