package com.orientalfinance.eastcloud.module.Retrofit;


import com.orientalfinance.eastcloud.module.javabean.Address;
import com.orientalfinance.eastcloud.module.javabean.Advertisement;
import com.orientalfinance.eastcloud.module.javabean.Application;
import com.orientalfinance.eastcloud.module.javabean.Appointment;
import com.orientalfinance.eastcloud.module.javabean.AppointmentProgram;
import com.orientalfinance.eastcloud.module.javabean.BankCardInfo;
import com.orientalfinance.eastcloud.module.javabean.Banner;
import com.orientalfinance.eastcloud.module.javabean.Collection;
import com.orientalfinance.eastcloud.module.javabean.Comment;
import com.orientalfinance.eastcloud.module.javabean.Detail;
import com.orientalfinance.eastcloud.module.javabean.DetailChannel;
import com.orientalfinance.eastcloud.module.javabean.FamilyMember;
import com.orientalfinance.eastcloud.module.javabean.FilePostResult;
import com.orientalfinance.eastcloud.module.javabean.History;
import com.orientalfinance.eastcloud.module.javabean.HomePageChannel;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;
import com.orientalfinance.eastcloud.module.javabean.Message;
import com.orientalfinance.eastcloud.module.javabean.SearchHot;
import com.orientalfinance.eastcloud.module.javabean.SearchResult;
import com.orientalfinance.eastcloud.module.javabean.TV;
import com.orientalfinance.eastcloud.module.javabean.Token;
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
     * 方法描述：更新token
     */
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<Token>> tokenFresh(@Field("s") String zip, @Field("sign") String sign);

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
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> modifyUserInfo(@Field("s") String zip, @Field("sign") String sign);


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


    //itype 369
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<BankCardInfo>>> showBankList(@Field("s") String zip, @Field("sign") String sign);

    //itype 370
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<BankCardInfo>> checkBank(@Field("s") String zip, @Field("sign") String sign);

    //itype 371
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> commitBank(@Field("s") String zip, @Field("sign") String sign);

    //itype 372
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> editBankPwd(@Field("s") String zip, @Field("sign") String sign);

    //itype 451
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<History>>> showHistory(@Field("s") String zip, @Field("sign") String sign);

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
    Flowable<EastCloudResponseBody<List<Collection>>> showMyCollection(@Field("s") String zip, @Field("sign") String sign);

    //itype 456

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> deleteMyCollection(@Field("s") String zip, @Field("sign") String sign);


    //itype 501

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> showMyCategory(@Field("s") String zip, @Field("sign") String sign);

    //itype 502

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Banner>>> showBanner(@Field("s") String zip, @Field("sign") String sign);
    //itype 503

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Advertisement>>> showAdvertisement(@Field("s") String zip, @Field("sign") String sign);
    //itype 504

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<HomepageProgram>>> showCurrentHit(@Field("s") String zip, @Field("sign") String sign);

    //itype 505

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<HomepageProgram>>> showProgramList(@Field("s") String zip, @Field("sign") String sign);
    //itype 506

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<SearchHot>>> showSearchHot(@Field("s") String zip, @Field("sign") String sign);

    //itype 507

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<SearchResult>>> showSearchResult(@Field("s") String zip, @Field("sign") String sign);

    //itype 508

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Detail>>> showProgramDetail(@Field("s") String zip, @Field("sign") String sign);

    //itype 509
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<Comment>>> showDetailComments(@Field("s") String zip, @Field("sign") String sign);

    //itype510
    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<DetailChannel>>> showDetailChannel(@Field("s") String zip, @Field("sign") String sign);


    //itype511

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<HomePageChannel.Category>>> showChannelCatelog(@Field("s") String zip, @Field("sign") String sign);


    //itype 512

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<HomePageChannel>>> showChanneList(@Field("s") String zip, @Field("sign") String sign);

    //itype 551

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> commitComment(@Field("s") String zip, @Field("sign") String sign);
    //itype 552

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody<List<AppointmentProgram>>> showAppointmentProgram(@Field("s") String zip, @Field("sign") String sign);
    //itype 553

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> addAppointmentProgram(@Field("s") String zip, @Field("sign") String sign);
    //itype 554

    @FormUrlEncoded
    @POST(".")
    Flowable<EastCloudResponseBody> addCollection(@Field("s") String zip, @Field("sign") String sign);

    @Multipart
    @POST(".")
    Call<ResponseResult> controller(@PartMap Map<String, RequestBody> params);

    //itype 750
    @Multipart
    @POST(".")
    Flowable<EastCloudResponseBody<List<Application>>> showAppList(@Field("s") String zip, @Field("sign") String sign);

}
