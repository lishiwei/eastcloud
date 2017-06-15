package com.orientalfinance.eastcloud.module.Retrofit.convert;

public interface ApiErrorCode {

    /** 客户端错误*/
    int ERROR_CLIENT_AUTHORIZED = 1;
    /** 用户授权失败*/
    int ERROR_USER_AUTHORIZED = 2;
    /** 请求参数错误*/
    int ERROR_REQUEST_PARAM = 3;
    /** 参数检验不通过 */
    int ERROR_PARAM_CHECK = 4;
    /** 自定义错误*/
    int ERROR_OTHER = 10;
    /** 无网络连接*/
    int ERROR_NO_INTERNET = 11;


    int ERROR_CONNECT_TIMEOUT= 12;

    /** 暂无数据*/
    int ERROR_NO_DATA = 13;
    String  ERROR_NO_DATASTRING = "暂无数据";

}
