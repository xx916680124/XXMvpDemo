package com.example.xxmvpdemo.base.p;

import android.content.Context;

import com.example.xxmvpdemo.base.v.IBaseSmartView1;
import com.example.xxmvpdemo.base.v.IBaseView;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;

/**
 * author : xx
 * time : 2020/8/8 10:06
 * describe :
 **/
public interface IBaseSmartPresenter1<D,V extends IBaseSmartView1<D,?>> extends IBasePresenter<V> {
    void setType(Class<D> type);
    void doRequest(MvpRequest<D> request);
}
