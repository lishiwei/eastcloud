package com.orientalfinance.eastcloud.module.Retrofit;


import com.orientalfinance.eastcloud.module.javabean.FilePostResult;
import com.orientalfinance.eastcloud.module.javabean.Movie;
import com.orientalfinance.eastcloud.module.javabean.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by 29435 on 2017/5/31.
 */

public interface EastCloudService {

    @GET("users/{user}/repos")
    Flowable<List<Movie>> getMovies(String s, String sn);

    @GET("users/{user}/repos")
    Flowable<User> login(String s, String sn);

    @GET("users/{user}/repos")
    Flowable<List<Movie>> changePassword(String s, String sn);

    @GET("users/{user}/repos")
    Flowable<List<Movie>> regist(String s, String sn);

    @GET("users/{user}/repos")
    Flowable<List<Movie>> getDedail(String s, String sn);

    /**
     * 方法描述：注册
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("registerUser")
    Call<RequestResult<User>> register(@Body SendRequest request);

    /**
     * 方法描述：发送验证码
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("codeSend")
    Call<RequestResult<User>> codeSend(@Body SendRequest request);

    /**
     * 方法描述：校验验证码
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("vailadCode")
    Call<RequestResult<User>> validateCode(@Body SendRequest request);

    /**
     * 方法描述：用户登录
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("userLogin")
    Call<RequestResult<User>> userLogin(@Body SendRequest request);

    /**
     * 方法描述：忘记密码
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("userLogin")
    Call<RequestResult<User>> forgetPwd(@Body SendRequest request);

    /**
     * 方法描述：修改密码
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("userLogin")
    Call<RequestResult<User>> updatePwd(@Body SendRequest request);

    /**
     * 方法描述：头像上传
     */
    @Multipart
    @POST("uploadFile")
    Call<RequestResult<FilePostResult>> uploadHeader(@PartMap Map<String, RequestBody> params);

    /**
     * 方法描述：修改头像
     */
    @Multipart
    @POST("editHeadImage")
    Call<RequestResult<Object>> editHeadImage(@PartMap Map<String, RequestBody> params);

    /**
     * 方法描述：个人信息修改
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("eidtMemberInfo")
    Call<RequestResult> updateUserInfo(@Body SendRequest request);

    /**
     * 方法描述：意见反馈
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("")
    Call<RequestResult> feedback(@Body SendRequest request);


}
