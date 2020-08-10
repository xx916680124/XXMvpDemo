package com.example.xxmvpdemo.base;

import com.example.xxmvpdemo.data.net.ok.response.MvpResponse;

import io.reactivex.rxjava3.disposables.Disposable;

/**
 * author : xx
 * time : 2020/8/8 9:04
 * describe :
 **/
public interface IBaseCallBack<T> {
    void onResult(MvpResponse<T> response);

    default void onStart(Disposable disposable){
    }
}
