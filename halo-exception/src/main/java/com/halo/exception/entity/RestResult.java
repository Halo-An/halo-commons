package com.halo.exception.entity;

import lombok.Data;

@Data
public class RestResult {

    private int code;

    private String msg;

    private Object data;

    public RestResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestResult(int code) {
        this.code = code;
    }

    public static RestResult success() {
        return new RestResult(RestResultEnum.SUCCESS.getCode(), RestResultEnum.SUCCESS.getMessage());
    }

    public static RestResult success(Object data) {
        return new RestResult(RestResultEnum.SUCCESS.getCode(), RestResultEnum.SUCCESS.getMessage(), data);
    }

    public static RestResult success(String msg) {
        return new RestResult(RestResultEnum.SUCCESS.getCode(), msg);
    }

    public static RestResult success(String msg, Object data) {
        return new RestResult(RestResultEnum.SUCCESS.getCode(), msg, data);
    }

    public static RestResult badRequest() {
        return new RestResult(RestResultEnum.BAD_REQUEST.getCode(), RestResultEnum.BAD_REQUEST.getMessage());
    }

    public static RestResult badRequest(String msg) {
        return new RestResult(RestResultEnum.BAD_REQUEST.getCode(), msg);
    }

    public static RestResult badRequest(Object data) {
        return new RestResult(RestResultEnum.BAD_REQUEST.getCode(), RestResultEnum.BAD_REQUEST.getMessage(), data);
    }

    public static RestResult badRequest(String msg, Object data) {
        return new RestResult(RestResultEnum.BAD_REQUEST.getCode(), msg, data);
    }

    public static RestResult unauthorized() {
        return new RestResult(RestResultEnum.UNAUTHORIZED.getCode(), RestResultEnum.UNAUTHORIZED.getMessage());
    }

    public static RestResult unauthorized(String msg) {
        return new RestResult(RestResultEnum.UNAUTHORIZED.getCode(), msg);
    }

    public static RestResult unauthorized(Object data) {
        return new RestResult(RestResultEnum.UNAUTHORIZED.getCode(), RestResultEnum.UNAUTHORIZED.getMessage(), data);
    }

    public static RestResult unauthorized(String msg, Object data) {
        return new RestResult(RestResultEnum.UNAUTHORIZED.getCode(), msg, data);
    }

    public static RestResult forbidden() {
        return new RestResult(RestResultEnum.FORBIDDEN.getCode(), RestResultEnum.FORBIDDEN.getMessage());
    }

    public static RestResult forbidden(String msg) {
        return new RestResult(RestResultEnum.FORBIDDEN.getCode(), msg);
    }

    public static RestResult forbidden(Object data) {
        return new RestResult(RestResultEnum.FORBIDDEN.getCode(), RestResultEnum.FORBIDDEN.getMessage(), data);
    }

    public static RestResult forbidden(String msg, Object data) {
        return new RestResult(RestResultEnum.FORBIDDEN.getCode(), msg, data);
    }

    public static RestResult notFound() {
        return new RestResult(RestResultEnum.NOT_FOUND.getCode(), RestResultEnum.NOT_FOUND.getMessage());
    }

    public static RestResult notFound(String msg) {
        return new RestResult(RestResultEnum.NOT_FOUND.getCode(), msg);
    }

    public static RestResult notFound(Object data) {
        return new RestResult(RestResultEnum.NOT_FOUND.getCode(), RestResultEnum.NOT_FOUND.getMessage(), data);
    }

    public static RestResult notFound(String msg, Object data) {
        return new RestResult(RestResultEnum.NOT_FOUND.getCode(), msg, data);
    }

    public static RestResult methodNotAllowed() {
        return new RestResult(RestResultEnum.METHOD_NOT_ALLOWED.getCode(), RestResultEnum.METHOD_NOT_ALLOWED.getMessage());
    }

    public static RestResult methodNotAllowed(String msg) {
        return new RestResult(RestResultEnum.METHOD_NOT_ALLOWED.getCode(), msg);
    }

    public static RestResult methodNotAllowed(Object data) {
        return new RestResult(RestResultEnum.METHOD_NOT_ALLOWED.getCode(), RestResultEnum.METHOD_NOT_ALLOWED.getMessage(), data);
    }

    public static RestResult methodNotAllowed(String msg, Object data) {
        return new RestResult(RestResultEnum.METHOD_NOT_ALLOWED.getCode(), msg, data);
    }

    public static RestResult requestTimeout() {
        return new RestResult(RestResultEnum.REQUEST_TIMEOUT.getCode(), RestResultEnum.REQUEST_TIMEOUT.getMessage());
    }

    public static RestResult requestTimeout(String msg) {
        return new RestResult(RestResultEnum.REQUEST_TIMEOUT.getCode(), msg);
    }

    public static RestResult requestTimeout(Object data) {
        return new RestResult(RestResultEnum.REQUEST_TIMEOUT.getCode(), RestResultEnum.REQUEST_TIMEOUT.getMessage(), data);
    }

    public static RestResult requestTimeout(String msg, Object data) {
        return new RestResult(RestResultEnum.REQUEST_TIMEOUT.getCode(), msg, data);
    }

    public static RestResult internalServerError() {
        return new RestResult(RestResultEnum.INTERNAL_SERVER_ERROR.getCode(), RestResultEnum.INTERNAL_SERVER_ERROR.getMessage());
    }

    public static RestResult internalServerError(String msg) {
        return new RestResult(RestResultEnum.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    public static RestResult internalServerError(Object data) {
        return new RestResult(RestResultEnum.INTERNAL_SERVER_ERROR.getCode(), RestResultEnum.INTERNAL_SERVER_ERROR.getMessage(), data);
    }

    public static RestResult internalServerError(String msg, Object data) {
        return new RestResult(RestResultEnum.INTERNAL_SERVER_ERROR.getCode(), msg, data);
    }

    public static RestResult badGateway() {
        return new RestResult(RestResultEnum.BAD_GATEWAY.getCode(), RestResultEnum.BAD_GATEWAY.getMessage());
    }

    public static RestResult badGateway(String msg) {
        return new RestResult(RestResultEnum.BAD_GATEWAY.getCode(), msg);
    }

    public static RestResult badGateway(Object data) {
        return new RestResult(RestResultEnum.BAD_GATEWAY.getCode(), RestResultEnum.BAD_GATEWAY.getMessage(), data);
    }

    public static RestResult badGateway(String msg, Object data) {
        return new RestResult(RestResultEnum.BAD_GATEWAY.getCode(), msg, data);
    }

    public static RestResult serviceUnavailable() {
        return new RestResult(RestResultEnum.SERVICE_UNAVAILABLE.getCode(), RestResultEnum.SERVICE_UNAVAILABLE.getMessage());
    }

    public static RestResult serviceUnavailable(String msg) {
        return new RestResult(RestResultEnum.SERVICE_UNAVAILABLE.getCode(), msg);
    }

    public static RestResult serviceUnavailable(Object data) {
        return new RestResult(RestResultEnum.SERVICE_UNAVAILABLE.getCode(), RestResultEnum.SERVICE_UNAVAILABLE.getMessage(), data);
    }

    public static RestResult serviceUnavailable(String msg, Object data) {
        return new RestResult(RestResultEnum.SERVICE_UNAVAILABLE.getCode(), msg, data);
    }

    public static RestResult gatewayTimeout() {
        return new RestResult(RestResultEnum.GATEWAY_TIMEOUT.getCode(), RestResultEnum.GATEWAY_TIMEOUT.getMessage());
    }

    public static RestResult gatewayTimeout(String msg) {
        return new RestResult(RestResultEnum.GATEWAY_TIMEOUT.getCode(), msg);
    }

    public static RestResult gatewayTimeout(Object data) {
        return new RestResult(RestResultEnum.GATEWAY_TIMEOUT.getCode(), RestResultEnum.GATEWAY_TIMEOUT.getMessage(), data);
    }

    public static RestResult gatewayTimeout(String msg, Object data) {
        return new RestResult(RestResultEnum.GATEWAY_TIMEOUT.getCode(), msg, data);
    }

    public static RestResult unknownError() {
        return new RestResult(RestResultEnum.UNKNOWN_ERROR.getCode(), RestResultEnum.UNKNOWN_ERROR.getMessage());
    }

    public static RestResult unknownError(String msg) {
        return new RestResult(RestResultEnum.UNKNOWN_ERROR.getCode(), msg);
    }

    public static RestResult unknownError(Object data) {
        return new RestResult(RestResultEnum.UNKNOWN_ERROR.getCode(), RestResultEnum.UNKNOWN_ERROR.getMessage(), data);
    }

    public static RestResult unknownError(String msg, Object data) {
        return new RestResult(RestResultEnum.UNKNOWN_ERROR.getCode(), msg, data);
    }
}
