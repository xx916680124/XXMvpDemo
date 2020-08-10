package com.example.xxmvpdemo.base.p;

import com.example.xxmvpdemo.base.v.IBaseSmartView2;
import com.example.xxmvpdemo.base.v.IBaseSmartView3;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;

/**
 * author : xx
 * time : 2020/8/8 10:06
 * describe :
 **/
public interface IBaseSmartPresenter3<D1,D2,D3,V extends IBaseSmartView3<D1,D2,D3,?>> extends IBaseSmartPresenter2<D1,D2,V> {
    void setType3(Class<D3> type);
    void doRequest3(MvpRequest<D3> request);
}
