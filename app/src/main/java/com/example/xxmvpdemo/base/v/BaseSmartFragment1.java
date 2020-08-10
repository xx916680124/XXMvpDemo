package com.example.xxmvpdemo.base.v;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.xxmvpdemo.base.p.BaseSmartPresenter1;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;

import java.lang.reflect.ParameterizedType;

/**
 * author : xx
 * time : 2020/8/8 10:28
 * describe :
 **/
public abstract class BaseSmartFragment1<D> extends BaseMvpFragment<BaseSmartPresenter1<D,?>> implements IBaseSmartView1<D,BaseSmartPresenter1<D,?>>{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<D> aClass= (Class<D>) superClass.getActualTypeArguments()[0];
        mPresenter.setType(aClass);
    }
    public void doRequest(MvpRequest<D> request){
        mPresenter.doRequest(request);
    }

    @Override
    public BaseSmartPresenter1<D, ?> createPresenter() {
        return new BaseSmartPresenter1<>();
    }
}
