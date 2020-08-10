package com.example.xxmvpdemo.base.v;

import com.example.xxmvpdemo.base.p.IBaseSmartPresenter1;
import com.example.xxmvpdemo.base.p.IBaseSmartPresenter2;
import com.example.xxmvpdemo.data.net.ok.response.MvpResponse;

/**
 * author : xx
 * time : 2020/8/8 10:24
 * describe :
 **/
public interface IBaseSmartView2<D1,D2,P extends IBaseSmartPresenter2<D1,D2,?>> extends IBaseSmartView1<D1,P> {
    void onResult2(MvpResponse<D2> response);
}
