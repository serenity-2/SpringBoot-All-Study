package com.jzjr.openfeignoperation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class SysUser {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户中文名
     */
    private String userCnName;

    /**
     * 用户密码
     */
    @JsonIgnore
    private String userPass;

    /**
     * 用户头像地址
     */
    private String userAvatar;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private LocalDateTime birth;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态:(0:待启用;1:正常;2:冻结)
     */
    private String status;

    /**
     * 工作流同步状态(0:待同步;1:已同步)
     */
    private String flowSysncFlag;

    /**
     * 创建时间
     */
    @JsonIgnore
    private LocalDateTime createDt;

    /**
     * 创建者
     */
    @JsonIgnore
    private String createBy;

    /**
     * 修改时间
     */
    @JsonIgnore
    private LocalDateTime modifyDt;

    /**
     * 修改者
     */
    @JsonIgnore
    private String modifyBy;

    /**
     * 备注
     */
    private String comments;

    private Integer errorLoginCnt;
}
