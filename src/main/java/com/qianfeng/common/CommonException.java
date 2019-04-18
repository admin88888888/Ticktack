package com.qianfeng.common;

import com.qianfeng.utils.JsonUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//@ControllerAdvice和@ResponseBody
@ControllerAdvice
@ResponseBody
public class CommonException {

    @ExceptionHandler(UnauthorizedException.class)
    public JsonBean permException(UnauthorizedException e){

        return JsonUtils.createJsonBean(0, e.getMessage());
    }

}
