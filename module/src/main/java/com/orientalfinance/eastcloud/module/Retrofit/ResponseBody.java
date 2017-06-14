package com.orientalfinance.eastcloud.module.Retrofit;

import com.orientalfinance.eastcloud.module.javabean.Result;

/**
 * 类描述：约定返回格式类型
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */
public class ResponseBody<T> {
    private int code;
    private String msg;
    private Result<T> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result<T> getResult() {
        return result;
    }

    public void setResult(Result<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
