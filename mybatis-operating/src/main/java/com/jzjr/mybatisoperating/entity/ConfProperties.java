package com.jzjr.mybatisoperating.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ConfProperties {

    private String pid;

    private String pkey;

    private String pdesc;

    private String pval;

    private String isvalid;

    private Date createdate;

    private String coper;

    private Date modifydate;

    private String moper;
    /**
     * 邮储银行
     */
//    private Yc yc;

    /**
     * 上海银行
     */
//    private Sh sh;

}
