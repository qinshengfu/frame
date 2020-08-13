package com.qsf.frame.handle;

import com.qsf.frame.exception.ResultEnumException;
import com.qsf.frame.utils.ResultVOUtil;
import com.qsf.frame.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一捕获异常处理
 * @Author QSF
 * @Date 2020/8/13 10:22
 * @Version 1.0
 */
@Slf4j
public class ResultEnumExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handle(Exception e) {
        if (e instanceof ResultEnumException) {
            ResultEnumException resultEnumException = (ResultEnumException) e;
            return ResultVOUtil.error(resultEnumException.getCode(), resultEnumException.getMessage());
        } else {
            log.error("【系统异常】{}", e);
            return ResultVOUtil.error(-1, "未知错误");
        }

    }
}
