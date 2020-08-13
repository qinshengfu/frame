package com.qsf.frame.exception;

import com.qsf.frame.enums.ResultEnum;
import lombok.Data;

/**
 * 统一异常
 * @Author QSF
 * @Date 2020/8/13 10:21
 * @Version 1.0
 */
@Data
public class ResultEnumException extends RuntimeException{

    private Integer code;

    public ResultEnumException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
