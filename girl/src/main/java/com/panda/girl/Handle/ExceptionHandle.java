package com.panda.girl.Handle;

import com.panda.girl.domain.Result;
import com.panda.girl.exception.GirlException;
import com.panda.girl.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 */
@ControllerAdvice
public class ExceptionHandle {
    /**
     * 处理Exception异常类
     * @param exception
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception exception){
        if(exception instanceof GirlException){
            GirlException girlException=(GirlException)exception;
            return ResultUtils.error(girlException.getMessage(),girlException.getCode());
        }else{

            return ResultUtils.error("系统异常",-1);
        }
    }
}
