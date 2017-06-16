package com.orientalfinance.eastcloud.mvp.base;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.hannesdorfmann.mosby.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby.mvp.delegate.FragmentMvpDelegateImpl;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.orientalfinance.eastcloud.App;
import com.orientalfinance.eastcloud.dagger.BaseFragmentComponent;
import com.orientalfinance.eastcloud.dagger.component.AppComponent;


import javax.inject.Inject;
import javax.inject.Provider;

public abstract class BaseFragment<COMPONENT extends BaseFragmentComponent,VIEW extends MvpView, PRESENTER extends MvpPresenter<VIEW>> extends Fragment
        implements BaseMvpDelegateCallback<VIEW, PRESENTER>, MvpView {
protected ViewDataBinding mViewDataBinding;
    protected FragmentMvpDelegate<VIEW, PRESENTER> mvpDelegate;
    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getMvpDelegate().onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater,getLayoutId(),null,false);
        return mViewDataBinding.getRoot();
    }

    /**
     * Can't inject directly, as the presenter instantiation needs to happen by mosby in {@link this#createPresenter()}.
     */

    @Inject
    Provider<PRESENTER> presenterProvider;

    /**
     * The presenter for this view. Will be instantiated with {@link #createPresenter()}
     */
    protected PRESENTER presenter;

    /**
     * Creates a new presenter instance, if needed. Will reuse the previous presenter instance if
     * {@link #setRetainInstance(boolean)} is set to true. This method will be called from
     * {@link #onViewCreated(View, Bundle)}
     */
    public  PRESENTER createPresenter(){
        return presenterProvider.get();
    }

    /**
     * * Get the mvp delegate. This is internally used for creating presenter, attaching and
     * detaching view from presenter.
     *
     * <p>
     * <b>Please note that only one instance of mvp delegate should be used per fragment
     * instance</b>.
     * </p>
     *
     * <p>
     * Only override this method if you really know what you are doing.
     * </p>
     *
     * @return {@link FragmentMvpDelegateImpl}
     */
    @NonNull
    protected FragmentMvpDelegate<VIEW, PRESENTER> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new FragmentMvpDelegateImpl<>(this);
        }

        return mvpDelegate;
    }

    @NonNull @Override public PRESENTER getPresenter() {
        return presenter;
    }

    @Override public void setPresenter(@NonNull PRESENTER presenter) {
        this.presenter = presenter;
    }

    @Override public boolean isRetainInstance() {
        return getRetainInstance();
    }

    @Override public boolean shouldInstanceBeRetained() {
        FragmentActivity activity = getActivity();
        boolean changingConfig = activity != null && activity.isChangingConfigurations();
        return getRetainInstance() && changingConfig;
    }

    @NonNull @Override public VIEW getMvpView() {
        return (VIEW) this;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getMvpDelegate().onViewCreated(view, savedInstanceState);

    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        getMvpDelegate().onDestroyView();
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        COMPONENT component = constructComponent(App.getApp().getAppComponent());
        component.inject(this);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @Override public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override public void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override public void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override public void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }


    protected abstract int getLayoutId();

    protected abstract COMPONENT constructComponent(AppComponent appComponent);

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        getMvpDelegate().onAttach(activity);
    }

    @Override public void onDetach() {
        super.onDetach();
        getMvpDelegate().onDetach();
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

}