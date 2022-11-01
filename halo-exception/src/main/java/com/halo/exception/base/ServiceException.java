package com.halo.exception.base;

public class ServiceException extends RuntimeException {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public static ServiceException t(String msg) {
        return new ServiceException(msg);
    }
}
