package com.jzjr.serializable.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Earth implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String shape = "sphere";

    private String volume;

    private String radius;

//    private String rotationPeriod;

    transient private String age;
}
