package com.isoftstone.honorplatform.constant;


import com.isoftstone.honorplatform.core.IBaseErrorCodeEnum;

public enum CommonErrorCodeEnum implements IBaseErrorCodeEnum {
    /**
     * 成功
     */
    SUCCESS("0", "Success", 200),
    /**
     * 非法参数
     */
    INVALID_PARAM("400", "Invalid param.", 400),
    /**
     * 内部错误
     */
    INTERNAL_SERVER_ERROR("500", "Internal server error.", 500);

    private final String code;

    private final String msg;

    private final int statusCode;

    CommonErrorCodeEnum(String code, String msg, int statusCode) {
        this.code = code;
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
