package com.halo.exception.handler;

import com.halo.exception.base.ServiceException;
import com.halo.exception.entity.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("ALL")
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult bindException(HttpServletRequest request,
                                    HttpServletResponse response,
                                    ServiceException exception) {
        return RestResult.internalServerError(exception.getMsg());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public RestResult exception(HttpServletRequest request,
                               HttpServletResponse response,
                               Exception exception) {
        return RestResult.internalServerError(exception.getMessage());
    }
}
