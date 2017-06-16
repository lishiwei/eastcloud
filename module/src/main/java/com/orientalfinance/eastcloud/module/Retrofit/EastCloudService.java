package com.orientalfinance.eastcloud.module.Retrofit;


import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.module.javabean.Appointment;
import com.orientalfinance.eastcloud.module.javabean.Channel;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;
import com.orientalfinance.eastcloud.module.javabean.FilePostResult;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.module.javabean.User;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by 29435 on 2017/5/31.
 */

public interface EastCloudService {


    /**
     * 方法描述：注册
     */
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<User>> register(@Field("s") String zip, @Field("sign") String sign);


    /**
     * 方法描述：发送验证码
     * itype 302
     */
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<Message>> codeSend(@Field("s") String zip, @Field("sign") String sign);

    /**
     * 方法描述：校验验证码(itype=303)
     */
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> validateCode(@Field("s") String zip, @Field("sign") String sign);

    /**
     * 方法描述：用户登录
     */
    @FormUrlEncoded
    @POST(".")
    Call<ResponseResult<User>> userLogin(@Field("s") String zip, @Field("sign") String sign);

    /**
     * 方法描述：忘记密码
     */
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<User>> forgetPwd(@Field("s") String zip, @Field("sign") String sign);

    /**
     * 方法描述：修改密码
     */
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> updatePwd(@Field("s") String zip, @Field("sign") String sign);

    /**
     * 方法描述：头像上传
     */
    @Multipart
    @POST("uploadFile")
    Call<ResponseResult<FilePostResult>> uploadHeader(@PartMap Map<String, RequestBody> params);

    /**
     * 方法描述：修改头像
     */
    @Multipart
    @POST("editHeadImage")
    Call<ResponseResult<Object>> editHeadImage(@PartMap Map<String, RequestBody> params);

    /**
     * 方法描述：个人信息修改
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("eidtMemberInfo")
    Call<ResponseResult> updateUserInfo(@Body SendRequest request);

    /**
     * 方法描述：意见反馈
     */
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @POST("")
    Call<ResponseResult> feedback(@Body SendRequest request);


    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<TV>>> showTvBoxList(@Field("s") String zip, @Field("sign") String sign);

    //itype:356
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> delTvBox(@Field("s") String zip, @Field("sign") String sign);

    //itype 357
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<TV>>> scanTvBox(@Field("s") String zip, @Field("sign") String sign);

    //itype 359
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> reportSuggest(@Field("s") String zip, @Field("sign") String sign);


    /**
     * test
     * TODO:
     *
     * @param zip
     * @param sign
     * @return
     */
    @FormUrlEncoded
    @POST(".")
    Call<ResponseResult> reportSuggest2(@Field("s") String zip, @Field("sign") String sign);


    //itype 360
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Address>>> getAddress(@Field("s") String zip, @Field("sign") String sign);

    //itype 360
    @FormUrlEncoded
    @POST(".")
    Call<ResponseResult<List<Address>>> getAddress1(@Field("s") String zip, @Field("sign") String sign);

    //itype 361
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> addAddress(@Field("s") String zip, @Field("sign") String sign);

    //itype 362
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> editAddress(@Field("s") String zip, @Field("sign") String sign);

    //itype 363
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> deleteAddress(@Field("s") String zip, @Field("sign") String sign);


    //itype 365
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<FamilyMember>>> showFamilyList(@Field("s") String zip, @Field("sign") String sign);

    //itype 366
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> addFamily(@Field("s") String zip, @Field("sign") String sign);

    //itype 367
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> editFamily(@Field("s") String zip, @Field("sign") String sign);

    //itype 368
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> deleteFamily(@Field("s") String zip, @Field("sign") String sign);


    //itype 451
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Channel>>> showHistory(@Field("s") String zip, @Field("sign") String sign);
    //itype 452
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> deleteHistory(@Field("s") String zip, @Field("sign") String sign);

    //itype 453
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Appointment>>> showAppiontment(@Field("s") String zip, @Field("sign") String sign);

    //itype 454
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> deleteAppiontment(@Field("s") String zip, @Field("sign") String sign);

    //itype 455

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Channel>>> showMyCollection(@Field("s") String zip, @Field("sign") String sign);

    //itype 456

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> deleteMyCollection(@Field("s") String zip, @Field("sign") String sign);


}
