package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * 类描述：约定返回格式类型
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */
public class RequestResult<T> {
    private int code;
    private String msg;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
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
