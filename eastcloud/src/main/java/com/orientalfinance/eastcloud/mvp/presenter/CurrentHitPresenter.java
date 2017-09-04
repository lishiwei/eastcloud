package com.orientalfinance.eastcloud.mvp.presenter;

import com.orientalfinance.eastcloud.module.Retrofit.ListTransform;
import com.orientalfinance.eastcloud.module.Retrofit.MyConsumer;
import com.orientalfinance.eastcloud.module.Retrofit.ObjectTransform;
import com.orientalfinance.eastcloud.module.Retrofit.RemoteDataProxy;
import com.orientalfinance.eastcloud.module.Retrofit.RequestParam;
import com.orientalfinance.eastcloud.module.core.AcacheUtil;
import com.orientalfinance.eastcloud.module.core.HomePageProgramRepository;
import com.orientalfinance.eastcloud.module.core.TimeUtils;
import com.orientalfinance.eastcloud.module.javabean.Advertisement;
import com.orientalfinance.eastcloud.module.javabean.Banner;
import com.orientalfinance.eastcloud.module.javabean.HomepageProgram;
import com.orientalfinance.eastcloud.module.javabean.Token;
import com.orientalfinance.eastcloud.module.javabean.User;
import com.orientalfinance.eastcloud.mvp.View.CurrentHitView;
import com.orientalfinance.eastcloud.mvp.base.MvpNullObjectBasePresenter;
import com.orientalfinance.eastcloud.utils.LogUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by 29435 on 2017/5/26.
 */

public class CurrentHitPresenter extends MvpNullObjectBasePresenter<CurrentHitView> {
    private static final String TAG = CurrentHitPresenter.class.getSimpleName();

    HomePageProgramRepository mHomePageProgramRepository;

    @Inject
    public CurrentHitPresenter(HomePageProgramRepository homePageProgramRepository) {

    }


    public void tokenRefresh(final RequestParam requestParam) {

        if (AcacheUtil.getInstance().getTokenRefreshEnable()) {

            LogUtils.d(TAG, "tokenRefresh: ");
            RemoteDataProxy.tokenFresh(requestParam)
                    .compose(new ObjectTransform<Token>()).subscribe(new Consumer<Token>() {
                @Override
                public void accept(@NonNull Token token) throws Exception {
                    LogUtils.d(TAG, "accept: " + token.toString());
                    User user = AcacheUtil.getInstance().getUser();
                    user.setToken(token.getToken());
                    AcacheUtil.getInstance().putUser(user);
                    AcacheUtil.getInstance().putTokenRefreshTime(TimeUtils.getNowString());
                }
            }, new MyConsumer<Throwable>() {
                @Override
                public void accept(@NonNull Throwable throwable) throws Exception {
                    super.accept(throwable);
                    LogUtils.d(TAG, "accept: " + throwable.getMessage());
                    getView().refreshTokenError();
                }
            });
        }
    }

    public void showBanner(RequestParam requestParam) {
        getView().showDialog();
        RemoteDataProxy.showBanner(requestParam).compose(new ListTransform<List<Banner>>()).subscribe(new Consumer<List<Banner>>() {
            @Override
            public void accept(@NonNull List<Banner> banners) throws Exception {
                getView().hideDialog();
                getView().showBanner(banners);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();

            }
        });
    }

    public void showAdvertisement(com.orientalfinance.eastcloud.module.Retrofit.RequestParam requestParam) {

        RemoteDataProxy.showAdvertisement(requestParam).compose(new ListTransform<List<Advertisement>>()).subscribe(new Consumer<List<Advertisement>>() {
            @Override
            public void accept(@NonNull List<Advertisement> advertisements) throws Exception {
                getView().showAdvertisement(advertisements);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }

    public void showCurrentHit(RequestParam requestParam) {
        RemoteDataProxy.showCurrentHit(requestParam).compose(new ListTransform<List<HomepageProgram>>()).subscribe(new Consumer<List<HomepageProgram>>() {
            @Override
            public void accept(@NonNull List<HomepageProgram> homepagePrograms) throws Exception {
                getView().showCurrentHit(homepagePrograms);
            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });
    }

    public void showProgramList(final RequestParam requestParam) {


        mHomePageProgramRepository.getDatas(requestParam).subscribe(new Consumer<List<HomepageProgram>>() {
            @Override
            public void accept(@NonNull List<HomepageProgram> homepagePrograms) throws Exception {

                getView().showProgramList(homepagePrograms);

            }
        }, new MyConsumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                super.accept(throwable);
                getView().hideDialog();
            }
        });


//        RemoteDataProxy.showProgramList(requestParam).compose(new ListTransform<List<HomepageProgram>>()).subscribe(new Consumer<List<HomepageProgram>>() {
//            @Override
//            public void accept(@NonNull List<HomepageProgram> homepagePrograms) throws Exception {
//
//                getView().showProgramList(homepagePrograms);
//
//            }
//        }, new MyConsumer<Throwable>() {
//            @Override
//            public void accept(@NonNull Throwable throwable) throws Exception {
//                super.accept(throwable);
//                getView().hideDialog();
//            }
//        });
    }

    @Override
    public void attachView(CurrentHitView view) {
        super.attachView(view);

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }


}
