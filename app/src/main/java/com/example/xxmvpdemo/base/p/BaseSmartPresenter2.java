package com.example.xxmvpdemo.base.p;

import com.example.xxmvpdemo.base.IBaseCallBack;
import com.example.xxmvpdemo.base.m.IBaseMode;
import com.example.xxmvpdemo.base.v.IBaseSmartView1;
import com.example.xxmvpdemo.base.v.IBaseSmartView2;
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
public class BaseSmartPresenter2<D1,D2, V extends IBaseSmartView2<D1,D2, ?>> extends BaseSmartPresenter1<D1,V> implements IBaseSmartPresenter2<D1,D2, V> {

    private Class<D2> mType;
    private IBaseMode mMode;
    private CompositeDisposable mCompositeDisposable;

    public BaseSmartPresenter2() {
        mMode = new BaseRepositroy();
    }

    public BaseSmartPresenter2(IBaseMode baseMode) {
        mMode = baseMode;
    }

    @Override
    public void setType2(Class<D2> type) {
        mType = type;
    }

    @Override
    public void doRequest2(MvpRequest<D2> request) {
        request.setType(mType);
        mMode.doRequest(getLifecycleProvider(), request, new IBaseCallBack<D2>() {
            @Override
            public void onStart(Disposable disposable) {
                handStart(disposable);
            }
            @Override
            public void onResult(MvpResponse<D2> response) {
                if (mView != null) {
                    mView.onResult2(response);
                }
            }
        });
    }
}
