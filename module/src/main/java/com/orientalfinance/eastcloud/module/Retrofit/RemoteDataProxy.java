package com.orientalfinance.eastcloud.module.Retrofit;

import android.content.Context;

import com.orientalfinance.eastcloud.module.ModuleContext;
import com.orientalfinance.eastcloud.module.Retrofit.encrypt.EncryptUtils;
import com.orientalfinance.eastcloud.module.javabean.FilePostResult;
import com.orientalfinance.eastcloud.module.javabean.User;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 类描述：业务层与后台数据IO入口类
 * Created by lzy on 2017/6/9.
 * email:lizy@oriental-finance.com
 */

public class RemoteDataProxy {
    private static final Object objectLock = new Object();
    private static RemoteDataProxy remoteDataProxy;

    private RemoteDataProxy(Context context) {
        ModuleContext.getInstance().init(context);
    }

    public static RemoteDataProxy getRemoteDataProxy(Context context) {
        if (remoteDataProxy == null) {
            synchronized (objectLock) {
                if (remoteDataProxy == null) {
                    remoteDataProxy = new RemoteDataProxy(context);
                }
            }
        }
        return remoteDataProxy;
    }

    /**
     * 方法描述：注册
     */
    public static void register(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .register(requestParamWrap(requestParam, 301))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：验证码发送
     */
    public static void codeSend(RequestParam requestParam, HttpCallBack httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .codeSend(requestParamWrap(requestParam, 302))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：校验验证码
     */
    public static void validateCode(RequestParam requestParam, HttpCallBack httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .validateCode(requestParamWrap(requestParam, 303))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：登录
     */
    public static void login(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .userLogin(requestParamWrap(requestParam, 304))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：忘记密码
     */
    public static void forgetPwd(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .forgetPwd(requestParamWrap(requestParam, 305))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：修改密码
     */

    public static void updatePwd(RequestParam requestParam, HttpCallBack httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .updatePwd(requestParamWrap(requestParam, 350))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：上传头像
     */
    public static void uploadHead(File file, HttpCallBack<FilePostResult> httpCallBack) {
        SendRequest sendRequest = requestParamWrap(new RequestParam(), 353);

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("s", toRequestBody(sendRequest.getS()));
        map.put("sign", toRequestBody(sendRequest.getSign()));
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        map.put("file\"; filename=\"" + file.getName(), fileBody);
        EastcloudRetrofit.getInstance().getEastCloudService().uploadHeader(map).enqueue(httpCallBack);
    }

    /**
     * 方法描述：修改头像
     */
    public static void updateHeader(RequestParam requestParam, File file, HttpCallBack httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, 351);

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("s", toRequestBody(sendRequest.getS()));
        map.put("sign", toRequestBody(sendRequest.getSign()));
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
        map.put("file\"; filename=\"" + file.getName(), fileBody);
        EastcloudRetrofit.getInstance().getEastCloudService().editHeadImage(map).enqueue(httpCallBack);
    }

    /**
     * 方法描述：个人信息修改
     */
    public static void editUserInfo(RequestParam requestParam, HttpCallBack httpCallBack) {
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .updateUserInfo(requestParamWrap(requestParam, 352))
                .enqueue(httpCallBack);
    }


    public static RequestBody toRequestBody(String value) {
        return RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), value);
    }

    private static SendRequest requestParamWrap(RequestParam requestParam, int itype) {
        String version = DeviceUtil.getVersion();
        String deviceId = DeviceUtil.getDeviceId();
        requestParam.setVersion(version);
        requestParam.setDeviceId(deviceId);
        requestParam.setItype(itype);
        String zip = EncryptUtils.getZip(requestParam);
        return new SendRequest(zip, EncryptUtils.encrypt(zip));
    }
}
