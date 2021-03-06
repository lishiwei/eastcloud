package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by 29435 on 2017/6/14.
 */

public class EastCloudResponseBody<T> {

    /**
     * code : 10
     * msg : 操作成功
     * result : [{"box_id":"12","box_lcation":"0","box_Status":"在线"},{"box_id":"13","box_lcation":"1","box_Status":"在线"}]
     */

    private String code;
    private String msg;
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
