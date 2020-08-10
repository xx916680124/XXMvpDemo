package com.example.xxmvpdemo.base.v;

import com.example.xxmvpdemo.base.p.IBaseSmartPresenter1;
import com.example.xxmvpdemo.data.net.ok.response.MvpResponse;

/**
 * author : xx
 * time : 2020/8/8 10:24
 * describe :
 **/
public interface IBaseSmartView1<D,P extends IBaseSmartPresenter1> extends IBaseView<P> {
    void onResult1(MvpResponse<D> response);
}
