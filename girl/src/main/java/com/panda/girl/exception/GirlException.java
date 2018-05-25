package com.panda.girl.exception;

import com.panda.girl.enums.ResultEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class GirlException extends RuntimeException {
    public Integer getCode() {
        return code;
    }
    private Integer code;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        Integer code = resultEnum.getCode();
        this.code= code;
    }
}
