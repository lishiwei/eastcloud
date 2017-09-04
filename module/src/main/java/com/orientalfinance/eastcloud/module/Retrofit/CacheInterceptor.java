//package com.orientalfinance.eastcloud.module.Retrofit;
//
//import android.text.TextUtils;
//import android.util.Log;
//
//import com.lzy.tinydev.common.base.BaseApplication;
//import com.lzy.tinydev.common.net.ConnectivityType;
//import com.lzy.tinydev.common.net.NetWorkStateManager;
//
//import java.io.IOException;
//
//import okhttp3.CacheControl;
//import okhttp3.Interceptor;
//import okhttp3.Request;
//import okhttp3.Response;
//
///**
// * 类描述：缓存拦截器
// * 作者：lzy on 2017/4/27 08:43
// * 邮箱：1556342503@qq.com
// */
//public class CacheInterceptor implements Interceptor {
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        Response response = chain.proceed(request);
//        if (NetWorkStateManager.getInstance(BaseApplication.getApplication()).getNetWorkState()
//                == ConnectivityType.OFFLINE) {
//            Response cacheResponse = response.newBuilder()
//                    .removeHeader("Pragma")
//                    .removeHeader("Cache-Control")
//                    //cache for cache seconds （缓存4周）
//                    .header("Cache-Control", "max-age=" + 60 * 60 * 24 * 28)
//                    .build();
//            Log.e("TAGTAG", "无网络时：缓存中取出数据");
//            return cacheResponse;
//        } else {
//            String cache = request.header("MY_Cache-Time");
//            if (!TextUtils.isEmpty(cache)) {//缓存时间不为空
//                Response cacheResponse = response.newBuilder()
//                        .removeHeader("Pragma")
//                        .removeHeader("Cache-Control")
//                        .header("Cache-Control", "max-age=" + cache)
//                        .build();
//                return cacheResponse;
//            } else {
//                return chain.proceed(request);
//            }
//        }
//    }
//}
