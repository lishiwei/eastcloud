package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by lzy on 2017/6/13.
 * email:lizy@oriental-finance.com
 */

public class ApiException extends RuntimeException {
    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;
    private int code;
    private String message;

    public ApiException() {
    }

    public ApiException(int code) {
        this.code = code;
    }


    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 方法描述：由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，在显示给用户
     */
//    public String getApiExceptionMessage() {
//        String message = "";
//        switch (code) {
//            case USER_NOT_EXIST:
//                message = "该用户不存在";
//                break;
//            case WRONG_PASSWORD:
//                message = "密码错误";
//                break;
//            default:
//                message = "未知错误";
//
//        }
//        return message;
//    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiExceptionMessage() {
        return "ApiException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
