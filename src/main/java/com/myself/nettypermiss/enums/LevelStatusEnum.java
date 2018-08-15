package com.myself.nettypermiss.enums;

import lombok.Getter;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 10:01 2018\8\15 0015
 */
@Getter
public enum LevelStatusEnum {
    HIGH_LEVEL(1,"[高级别]"),
    MEDIUM_LEVEL(2,"[中级别]"),
    LOW_LEVEL(3,"[低级别]"),
    ;
    private Integer code;

    private String msg;

    LevelStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
