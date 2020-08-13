package com.qsf.frame.enums;

import lombok.Getter;

/**
 * 统一枚举
 * @Author QSF
 * @Date 2020/8/13 10:20
 * @Version 1.0
 */
@Getter
public enum ResultEnum {
    UNKONW_ERROR(-1001, "未知错误"),
    SUCCESS(0, "成功"),
    ;

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
