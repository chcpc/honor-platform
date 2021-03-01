package com.isoftstone.honorplatform.core;

import static com.isoftstone.honorplatform.core.BaseConstant.SUCCESS_CODE;
import static com.isoftstone.honorplatform.core.BaseConstant.SUCCESS_MSG;

public final class RestResult<T> {
    /**
     * 响应码
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 内容
     */
    private T data;

    private RestResult() {
    }

    public RestResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static RestResult success() {
        return RestResult.success(null);
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static RestResult failed(IBaseErrorCodeEnum errorCodeEnum) {
        return RestResult.failed(errorCodeEnum, null);
    }

    public static <T> RestResult<T> failed(IBaseErrorCodeEnum errorCodeEnum, T data) {
        return new RestResult<>(errorCodeEnum.getCode(), errorCodeEnum.getMsg(), data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
