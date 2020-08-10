package com.example.xxmvpdemo.base.v;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;

import com.example.xxmvpdemo.base.p.IBasePresenter;
import com.example.xxmvpdemo.widgets.LoadingView;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

/**
 * author : xx
 * time : 2020/8/8 9:48
 * describe :
 **/
public interface BaseView {
    default void showPopLoading() {
        showLoading(LoadingView.MODE_POP,false);
    }

    default void showPopLoading(boolean isEnableBackCancel) {

        showLoading(LoadingView.MODE_POP,isEnableBackCancel);
    }
    default void showFullLoading() {
        showLoading(LoadingView.MODE_FULL,false);
    }
    default void showFullLoading(boolean isEnableBackCancel) {
        showLoading(LoadingView.MODE_FULL,isEnableBackCancel);
    }
    default void closeLoading() {
        getLoadingView().closeLoading();
    }

    default void onError() {
        getLoadingView().onError();
    }
    default void onError(LoadingView.OnRetryCallBack onRetryCallBack) {
        getLoadingView().onError(onRetryCallBack);
    }
    default void onError(String message, LoadingView.OnRetryCallBack callBack) {
        getLoadingView().onError(message,callBack);
    }

    default void showLoading(@LoadingView.LoadingMode int mode,boolean isEnableBackCancel) {
        LoadingView loadingView = LoadingView.inject(getDefaultLoadingParent());
        loadingView.setEnableBackCancel(isEnableBackCancel);

        if(isEnableBackCancel){
            loadingView.setCancelCallBack(new LoadingView.OnCancelCallBack() {
                @Override
                public void onCancel() {
                    if(getPresenter() != null){
                        getPresenter().cancelRequest();
                    }

                }
            });
        }
        setLoadView(loadingView);
        loadingView.showLoading(mode);
    }


    default ViewGroup getDefaultLoadingParent() {
        if (this instanceof RxAppCompatActivity) {
            return (ViewGroup) findViewById(android.R.id.content);
        } else if (this instanceof BaseMvpFragment) {
            return (ViewGroup) ((BaseMvpFragment) this).getView();
        }
        return null;
    }

    <T extends View> T findViewById(@IdRes int id);


    void setLoadView(LoadingView loadView);

    LoadingView getLoadingView();

    IBasePresenter getPresenter();
}
