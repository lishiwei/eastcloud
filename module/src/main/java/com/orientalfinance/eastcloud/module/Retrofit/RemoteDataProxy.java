package com.orientalfinance.eastcloud.module.Retrofit;

import android.content.Context;
import android.util.Log;

import com.orientalfinance.eastcloud.module.ModuleContext;
import com.orientalfinance.eastcloud.module.Retrofit.configration.Constant;
import com.orientalfinance.eastcloud.module.Retrofit.encrypt.EncryptUtils;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.module.javabean.Appointment;
import com.orientalfinance.eastcloud.module.javabean.Channel;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;
import com.orientalfinance.eastcloud.module.javabean.FilePostResult;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.module.util.DeviceUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;
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
    public static Flowable<EastCloudResponseBody<User>> register(RequestParam requestParam) {
        SendRequest sendRequest = requestNoTokenParamWrap(requestParam, Constant.IType.REGISTER);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .register(sendRequest.getS(), sendRequest.getSign());

    }

    /**
     * 方法描述：验证码发送(itype=302)
     */
    public static Flowable<EastCloudResponseBody<Message>> codeSend(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.CODE_SEND);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .codeSend(sendRequest.getS(), sendRequest.getSign());

    }

    /**
     * 方法描述：校验验证码(itype=303)
     */
    public static Flowable<EastCloudResponseBody> validateCode(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.VALIDATE_CODE);

        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .validateCode(sendRequest.getS(), sendRequest.getSign());
        // .validateCode(new Gson().toJson(requestParam), new Gson().toJson(requestParam))
    }

    /**
     * 方法描述：登录(itype=304)
     */
    public static void login(RequestParam requestParam, HttpCallBack<User> httpCallBack) {
        SendRequest sendRequest = requestNoTokenParamWrap(requestParam, Constant.IType.LOGIN);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .userLogin(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);
    }

    /**
     * 方法描述：忘记密码(itype=305)
     */
    public static Flowable<EastCloudResponseBody<User>> forgetPwd(RequestParam requestParam) {
        SendRequest sendRequest = requestNoTokenParamWrap(requestParam, Constant.IType.FORGET_PWD);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .forgetPwd(sendRequest.getS(), sendRequest.getSign());

    }

    /**
     * 方法描述：修改密码(itype=350)
     */
    public static Flowable<EastCloudResponseBody> updatePwd(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.UPDATE_PWD);
       return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .updatePwd(sendRequest.getS(), sendRequest.getSign());
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

    /**
     * 方法描述：显示已绑定的机顶盒
     * itype 355
     */
    public static Flowable<EastCloudResponseBody<List<TV>>> showTvBoxList(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_TV_BOX_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .showTvBoxList(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：删除已绑定的机顶盒
     * itype 356
     */
    public static Flowable<EastCloudResponseBody> delTvBox(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.DELETE_TV_BOX);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .delTvBox(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：扫描已绑定的机顶盒
     * itype 357
     */
    public static Flowable<EastCloudResponseBody<List<TV>>> scanTvBox(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SCAN_SHOW_TV_BOX_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .scanTvBox(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：意见反馈
     * itype 359
     */
    public static Flowable<EastCloudResponseBody> reportSuggest(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.USER_FEEDBACK);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .reportSuggest(sendRequest.getS(), sendRequest.getSign());
    }

    public static void reportSuggestTest(RequestParam requestParam, HttpCallBack httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.USER_FEEDBACK);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .reportSuggest2(sendRequest.getS(), sendRequest.getSign())
                .enqueue(httpCallBack);

    }

    /**
     * 方法描述：获取地址
     * itype 360
     */
    public static Flowable<EastCloudResponseBody<List<Address>>> getAddress(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_MY_ADDRESS_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .getAddress(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：获取地址
     * itype 360
     */
    public static void getAddress1(RequestParam requestParam, HttpCallBack<List<Address>> httpCallBack) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_MY_ADDRESS_LIST);
        EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .getAddress1(sendRequest.getS(), sendRequest.getSign()).enqueue(httpCallBack);
    }

    /**
     * 方法描述：添加地址
     * itype 361
     */
    public static Flowable<EastCloudResponseBody> addAddress(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.ADD_MY_ADDRESS_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .addAddress(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：添加地址
     * itype 362
     */
    public static Flowable<EastCloudResponseBody> editAddress(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.EDIT_MY_ADDRESS_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .editAddress(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：删除地址
     * itype 363
     */
    public static Flowable<EastCloudResponseBody> deleteAddress(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.DELETE_MY_ADDRESS_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .deleteAddress(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：显示家庭成员
     * itype 365
     */
    public static Flowable<EastCloudResponseBody<List<FamilyMember>>> showFamilyList(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_FAMILY_LIST);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .showFamilyList(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：显示家庭成员
     * itype 366
     */
    public static Flowable<EastCloudResponseBody> addFamily(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.ADD_FAMILY);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .addFamily(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：编辑家庭成员
     * itype 367
     */
    public static Flowable<EastCloudResponseBody> editFamily(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.EDIT_FAMILY);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .editFamily(sendRequest.getS(), sendRequest.getSign());
    }

    /**
     * 方法描述：编辑家庭成员
     * itype 368
     */
    public static Flowable<EastCloudResponseBody> deleteFamily(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.DELETE_FAMILY);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .deleteFamily(sendRequest.getS(), sendRequest.getSign());
    }  /**
     * 方法描述：查看历史记录
     * itype 451
     */
    public static Flowable<EastCloudResponseBody<List<Channel>>> showHistory(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_WATCH_HISTORY);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .showHistory(sendRequest.getS(), sendRequest.getSign());
    }
    /**
     * 方法描述：删除历史记录
     * itype 452
     */
    public static Flowable<EastCloudResponseBody> deleteHistory(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.DELETE_WATCH_HISTORY);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .deleteHistory(sendRequest.getS(), sendRequest.getSign());

    }
    /**
     * 方法描述：显示预约
     * itype 453
     */
    public static Flowable<EastCloudResponseBody<List<Appointment>>> showAppointment(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_MY_APPOINTMENT);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .showAppiontment(sendRequest.getS(), sendRequest.getSign());

    }   /**
     * 方法描述：删除预约
     * itype 454
     */
    public static Flowable<EastCloudResponseBody> deleteAppointment(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.DELETE_MY_APPOINTMENT);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .deleteAppiontment(sendRequest.getS(), sendRequest.getSign());

    }
    /**
     * 方法描述：显示收藏
     * itype 455
     */
    public static Flowable<EastCloudResponseBody<List<Channel>>> showMyCollection(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.SHOW_MY_COLLECTION);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .showMyCollection(sendRequest.getS(), sendRequest.getSign());

    }
    /**
     * 方法描述：删除收藏
     * itype 456
     */
    public static Flowable<EastCloudResponseBody> deleteMyCollection(RequestParam requestParam) {
        SendRequest sendRequest = requestParamWrap(requestParam, Constant.IType.DELETE_MY_COLLECTION);
        return EastcloudRetrofit.getInstance()
                .getEastCloudService()
                .deleteMyCollection(sendRequest.getS(), sendRequest.getSign());

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
        requestParam.setToken(AcacheUtil.getInstance().getUser()==null?null:AcacheUtil.getInstance().getUser().getToken());
        requestParam.setItype(itype);
//        requestParam.setUid("402881ab5ca4a196015ca4a1966a0000");
        Log.e("OKHTTP", "请求参数：" + requestParam.toString());
        return new SendRequest(EncryptUtils.getZip(requestParam), EncryptUtils.encrypt(requestParam));
    }

    /**
     * 方法描述：重新包装request参数
     */
    private static SendRequest requestNoTokenParamWrap(RequestParam requestParam, int itype) {
        String version = DeviceUtil.getVersion();
        String deviceId = DeviceUtil.getDeviceId();
        requestParam.setVersion(version);
        requestParam.setDeviceId(deviceId);
        requestParam.setItype(itype);
        Log.e("OKHTTP", "请求参数：" + requestParam.toString());
        return new SendRequest(EncryptUtils.getZip(requestParam), EncryptUtils.encrypt(requestParam));
    }
}
