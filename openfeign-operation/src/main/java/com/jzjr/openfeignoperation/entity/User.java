package com.jzjr.openfeignoperation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author taobushi
 * @since 2019-09-02
 */
@Data
@TableName("sys_user")
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户中文名
     */
    @TableField("user_cn_name")
    private String userCnName;

    /**
     * 用户密码
     */
    @TableField("user_pass")
    @JsonIgnore
    private String userPass;

    /**
     * 用户头像地址
     */
    @TableField("user_avatar")
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
    @TableField("flow_sysnc_flag")
    private String flowSysncFlag;

    /**
     * 创建时间
     */
    @TableField("create_dt")
    @JsonIgnore
    private LocalDateTime createDt;

    /**
     * 创建者
     */
    @TableField("create_by")
    @JsonIgnore
    private String createBy;

    /**
     * 修改时间
     */
    @TableField("modify_dt")
    @JsonIgnore
    private LocalDateTime modifyDt;

    /**
     * 修改者
     */
    @TableField("modify_by")
    @JsonIgnore
    private String modifyBy;

    /**
     * 备注
     */
    @TableField("comments")
    private String comments;

    @TableField("error_login_cnt")
    private Integer errorLoginCnt;
}
