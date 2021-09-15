package com.jzjr.response_resultoperation.bean;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String id;

    private String userName;
}
