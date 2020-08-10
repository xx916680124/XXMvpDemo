package com.example.xxmvpdemo.base.p;

import android.content.Context;

import com.example.xxmvpdemo.base.v.IBaseView;
import com.trello.rxlifecycle4.LifecycleProvider;

/**
 * author : xx
 * time : 2020/8/8 10:30
 * describe :
 **/
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V mView;

    @Override
    public void bindView(V view) {
        mView = view;
    }

    @Override
    public void unBind() {

    }

    @Override
    public Context getMvpContent() {
        if (mView != null) {
            return mView.getMvpContent();
        }
        return null;
    }

    public LifecycleProvider getLifecycleProvider(){
        return (LifecycleProvider) mView;
    }
}
