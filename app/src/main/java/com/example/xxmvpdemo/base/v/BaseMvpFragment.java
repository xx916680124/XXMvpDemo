package com.example.xxmvpdemo.base.v;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.xxmvpdemo.base.p.IBasePresenter;
import com.example.xxmvpdemo.widgets.LoadingView;

/**
 * author : xx
 * time : 2020/8/8 11:40
 * describe :
 **/
public abstract class BaseMvpFragment<P extends IBasePresenter> extends BaseFragment implements IBaseView<P>, BaseView {

    protected P mPresenter;
    protected LoadingView mLoadingView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.bindView(this);
    }

    @Override
    public Context getMvpContent() {
        return getContext();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unBind();
    }

    @Override
    public IBasePresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setLoadView(LoadingView loadView) {
        mLoadingView = loadView;
    }

}
