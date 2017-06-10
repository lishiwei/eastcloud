package com.orientalfinance.eastcloud.module.Retrofit;

/**
 * Created by lzy on 2017/6/10.
 * email:lizy@oriental-finance.com
 */

public class RequestParam<T> {
    //    itype:业务方法值 num型  00-30
//    deviceId: 设备的唯一码 安卓可以是IMEI , IOS可以是广告标识符
//    data:业务对象{object}
//    token:string(登录请求后获得)
//    version:软件版本号
    private int itype;
    private String deviceId;
    String token;
    String version;
    T data;

    public int getItype() {
        return itype;
    }

    public void setItype(int itype) {
        this.itype = itype;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "itype=" + itype +
                ", deviceId='" + deviceId + '\'' +
                ", token='" + token + '\'' +
                ", version='" + version + '\'' +
                ", data=" + data +
                '}';
    }
}
