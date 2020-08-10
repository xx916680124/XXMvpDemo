package com.example.xxmvpdemo.base.p;

import android.content.Context;

import com.example.xxmvpdemo.base.v.IBaseView;

/**
 * author : xx
 * time : 2020/8/8 10:06
 * describe :
 **/
public interface IBasePresenter<V extends IBaseView> {
    void bindView(V view);
    void unBind();
    Context getMvpContent();
    /**
     * fetch data by rule id
     * @return boolean 取消请求
     */
    boolean cancelRequest();
}
