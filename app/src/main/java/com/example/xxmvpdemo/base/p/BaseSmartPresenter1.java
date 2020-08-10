package com.example.xxmvpdemo.base.p;

import android.content.Context;

import androidx.appcompat.view.menu.MenuView;

import com.example.xxmvpdemo.base.IBaseCallBack;
import com.example.xxmvpdemo.base.m.IBaseMode;
import com.example.xxmvpdemo.base.v.IBaseSmartView1;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;
import com.example.xxmvpdemo.data.net.ok.response.MvpResponse;
import com.example.xxmvpdemo.data.repositroy.BaseRepositroy;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * author : xx
 * time : 2020/8/8 10:29
 * describe :
 **/
public class BaseSmartPresenter1<D, V extends IBaseSmartView1<D, ?>> extends BasePresenter<V> implements IBaseSmartPresenter1<D, V> {

    private Class<D> mType;
    private IBaseMode mMode;
    private CompositeDisposable mCompositeDisposable;

    public BaseSmartPresenter1() {
        mMode = new BaseRepositroy();
    }

    public BaseSmartPresenter1(IBaseMode baseMode) {
        mMode = baseMode;
    }

    @Override
    public void setType(Class<D> type) {
        mType = type;
    }

    @Override
    public void doRequest(MvpRequest<D> request) {
        request.setType(mType);
        mMode.doRequest(getLifecycleProvider(), request, new IBaseCallBack<D>() {
            @Override
            public void onStart(Disposable disposable) {
                handStart(disposable);
            }
            @Override
            public void onResult(MvpResponse<D> response) {
                if (mView != null) {
                    mView.onResult1(response);
                }
            }
        });
    }

    @Override
    public boolean cancelRequest() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            return true;
        }
        return false;
    }

    protected void handStart(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
