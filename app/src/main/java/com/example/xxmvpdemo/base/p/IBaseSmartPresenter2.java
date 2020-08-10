package com.example.xxmvpdemo.base.p;

import com.example.xxmvpdemo.base.v.IBaseSmartView1;
import com.example.xxmvpdemo.base.v.IBaseSmartView2;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;

/**
 * author : xx
 * time : 2020/8/8 10:06
 * describe :
 **/
public interface IBaseSmartPresenter2<D1,D2,V extends IBaseSmartView2<D1,D2,?>> extends IBaseSmartPresenter1<D1,V> {
    void setType2(Class<D2> type);
    void doRequest2(MvpRequest<D2> request);
}
