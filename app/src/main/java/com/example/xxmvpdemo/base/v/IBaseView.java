package com.example.xxmvpdemo.base.v;

import android.content.Context;

import com.example.xxmvpdemo.base.p.IBasePresenter;

/**
 * author : xx
 * time : 2020/8/8 9:46
 * describe :
 **/
public interface IBaseView<P extends IBasePresenter> {
    P createPresenter();
    Context getMvpContent();
}
