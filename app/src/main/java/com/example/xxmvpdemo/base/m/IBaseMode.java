package com.example.xxmvpdemo.base.m;

import com.example.xxmvpdemo.base.IBaseCallBack;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;
import com.trello.rxlifecycle4.LifecycleProvider;

/**
 * author : xx
 * time : 2020/8/8 9:02
 * describe :
 **/
public interface IBaseMode {
    <T> void doRequest(LifecycleProvider lifecycleProvider, MvpRequest<T> request, IBaseCallBack<T> callBack);
}
