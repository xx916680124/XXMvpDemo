package com.example.xxmvpdemo.base.v;

import com.example.xxmvpdemo.base.p.IBaseSmartPresenter2;
import com.example.xxmvpdemo.base.p.IBaseSmartPresenter3;
import com.example.xxmvpdemo.data.net.ok.response.MvpResponse;

/**
 * author : xx
 * time : 2020/8/8 10:24
 * describe :
 **/
public interface IBaseSmartView3<D1,D2,D3,P extends IBaseSmartPresenter3<D1,D2,D3,?>> extends IBaseSmartView2<D1,D2,P> {
    void onResult3(MvpResponse<D3> response);
}
