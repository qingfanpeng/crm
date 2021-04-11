package com.peng.crm.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author qingfan
 * @creat 2021-04-10-0:15
 */
@ControllerAdvice
public class UnAuthorizationExceptionHandler {

    @ExceptionHandler
    public String UnAuthorizationHandler(AuthorizationException e) {
        return "unauthorize";
    }
}
