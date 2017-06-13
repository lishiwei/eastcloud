package com.orientalfinance.eastcloud.module.Retrofit;

import android.content.Context;
import android.util.Log;

import com.orientalfinance.eastcloud.module.ModuleContext;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.Retrofit.encrypt.EncryptUtils;
import com.orientalfinance.eastcloud.module.javabean.FilePostResult;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.module.util.DeviceUtil;

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
     * 方法描述：注册(itype=301)
     */
    public static void register(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.REGISTER);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .register(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：验证码发送(itype=302)
     */
    public static void codeSend(RequestParam requestParam, HttpCallBack httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.CODE_SEND);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .codeSend(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：校验验证码(itype=303)
     */
    public static void validateCode(RequestParam requestParam, HttpCallBack httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.VALIDATE_CODE);
//        String version = DeviceUtil.getVersion();
//        String deviceId = DeviceUtil.getDeviceId();
//        requestParam.setVersion(version);
//        requestParam.setDeviceId(deviceId);
//        requestParam.setItype(303);
//        String zip = EncryptUtils.getZip(requestParam);
//        String encrypt = EncryptUtils.encrypt(requestParam);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .validateCode(sendRequest.getS(), sendRequest.getSign())
                // .validateCode(new Gson().toJson(requestParam), new Gson().toJson(requestParam))
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：登录(itype=304)
     */
    public static void login(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.LOGIN);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .userLogin(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：忘记密码(itype=305)
     */
    public static void forgetPwd(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.FORGET_PWD);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .forgetPwd(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：修改密码(itype=350)
     */
    public static void updatePwd(RequestParam requestParam, HttpCallBack httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.UPDATE_PWD);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .updatePwd(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：上传头像
     */
    public static void uploadHead(File file, HttpCallBack<FilePostResult> httpCallBack) {
        SendRequest sendRequest = requestParamWrap(new RequestParam(), Constant.IType.AVATAR_UPLOAD);

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

    /**
     * 方法描述：重新包装request参数
     */
    private static SendRequest requestParamWrap(RequestParam requestParam, int itype) {
        String version = DeviceUtil.getVersion();
        String deviceId = DeviceUtil.getDeviceId();
        requestParam.setVersion(version);
        requestParam.setDeviceId(deviceId);
        requestParam.setItype(itype);
        Log.e("OKHTTP", "请求参数：" + requestParam.toString());
        return new SendRequest(EncryptUtils.getZip(requestParam), EncryptUtils.encrypt(requestParam));
    }
}
