package com.jzjr.cacheoperation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 *
 * @TableName t_user
 */
@TableName(value = "t_user")
@Data
@Accessors(chain = true)
public class TUser implements Serializable {
    /**
     * 用户ID
     */
    @TableId
    private Integer id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 公司名称
     */
    private String company;

    /**
     * 用户类型（00系统用户）
     */
    private String userType;
    /**
     * 微信openId
     */
    private String wxOpenId;
    /**
     * 设备Id
     */
    private String deviceId;
    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private Date loginDate;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDt;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDt;

    /**
     * 备注
     */
    private String remark;
    /**
     * 是否首次登录（0否 1是）
     */
    private String isFirstLogin;
    /**
     * 上次登录方式（0人脸 1短信验证码 2未知）
     */
    private String lastLoginType;
    /**
     * 机构编号
     */
    private String orgCode;
    /**
     * 用户唯一标识
     */
    private String userId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}