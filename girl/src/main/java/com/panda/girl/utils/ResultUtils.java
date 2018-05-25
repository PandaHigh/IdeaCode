package com.panda.girl.utils;

import com.panda.girl.domain.Result;

public class ResultUtils {
    public static Result success(Object object){
        Result result = new Result();
        result.setMsg("successful");
        result.setCode(0);
        result.setData(object);
        return result;
    }
    public static Result error(String errorMsg,Integer errorCode){
        Result result = new Result();
        result.setData(null);
        result.setCode(errorCode);
        result.setMsg(errorMsg);
        return result;
    }
}
