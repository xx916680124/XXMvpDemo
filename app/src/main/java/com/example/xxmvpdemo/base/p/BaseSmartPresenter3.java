package com.example.xxmvpdemo.base.p;

import com.example.xxmvpdemo.base.IBaseCallBack;
import com.example.xxmvpdemo.base.m.IBaseMode;
import com.example.xxmvpdemo.base.v.IBaseSmartView2;
import com.example.xxmvpdemo.base.v.IBaseSmartView3;
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
public class BaseSmartPresenter3<D1,D2,D3, V extends IBaseSmartView3<D1,D2,D3, ?>> extends BaseSmartPresenter2<D1,D2,V> implements IBaseSmartPresenter3<D1,D2,D3, V> {

    private Class<D3> mType;
    private IBaseMode mMode;
    private CompositeDisposable mCompositeDisposable;

    public BaseSmartPresenter3() {
        mMode = new BaseRepositroy();
    }

    public BaseSmartPresenter3(IBaseMode baseMode) {
        mMode = baseMode;
    }


    @Override
    public void setType3(Class<D3> type) {
        mType = type;
    }


    @Override
    public void doRequest3(MvpRequest<D3> request) {
        request.setType(mType);
        mMode.doRequest(getLifecycleProvider(), request, new IBaseCallBack<D3>() {
            @Override
            public void onStart(Disposable disposable) {
                handStart(disposable);
            }
            @Override
            public void onResult(MvpResponse<D3> response) {
                if (mView != null) {
                    mView.onResult3(response);
                }
            }
        });
    }
}
