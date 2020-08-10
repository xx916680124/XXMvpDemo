package com.example.xxmvpdemo.base.v;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.xxmvpdemo.base.p.IBasePresenter;
import com.example.xxmvpdemo.widgets.LoadingView;

/**
 * author : xx
 * time : 2020/8/10 10:40
 * describe :
 **/
public abstract class BaseMvpActivity<P extends IBasePresenter> extends BaseActivity implements BaseView,IBaseView<P> {

    private LoadingView mLoadingView;

    protected P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.bindView(this);

        loadData();
    }

/*
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(mPresenter != null){
                if(mPresenter.cancelRequest()){
                    closeLoading();
                    return true;
                }
            }

        }

        return super.onKeyUp(keyCode, event);

    }*/

    protected abstract void loadData();

    @Override
    public void setLoadView(LoadingView loadView) {
        mLoadingView = loadView;
    }

    @Override
    public LoadingView getLoadingView() {
        return mLoadingView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unBind();
    }
}