package com.qsf.frame.vo;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @Author QSF
 * @Date 2020/8/13 10:26
 * @Version 1.0
 */
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
