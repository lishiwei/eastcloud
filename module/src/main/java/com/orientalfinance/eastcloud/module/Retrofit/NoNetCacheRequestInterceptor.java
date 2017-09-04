//package com.orientalfinance.eastcloud.module.Retrofit;
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
// * 类描述：没有网络时缓存请求拦截器
// * Created by lzy on 2017/7/5.
// * email:lizy@oriental-finance.com
// */
//
//public class NoNetCacheRequestInterceptor implements Interceptor {
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        if (NetWorkStateManager.getInstance(BaseApplication.getApplication()).getNetWorkState() == ConnectivityType.OFFLINE) {
//            request = request.newBuilder()
//                    .cacheControl(CacheControl.FORCE_CACHE)
//                    .build();
//            return chain.proceed(request);
//        }
//        return chain.proceed(request);
//    }
//}
