package com.example.xxmvpdemo.base.v;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.xxmvpdemo.base.p.BaseSmartPresenter1;
import com.example.xxmvpdemo.base.p.BaseSmartPresenter2;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;

import java.lang.reflect.ParameterizedType;

/**
 * author : xx
 * time : 2020/8/8 10:28
 * describe :
 **/
public abstract class BaseSmartFragment2<D1,D2> extends BaseMvpFragment<BaseSmartPresenter2<D1,D2,?>> implements IBaseSmartView2<D1,D2,BaseSmartPresenter2<D1,D2,?>>{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<D1> aClass= (Class<D1>) superClass.getActualTypeArguments()[0];
        Class<D2> aClass2= (Class<D2>) superClass.getActualTypeArguments()[1];
        mPresenter.setType(aClass);
    }
    public void doRequest2(MvpRequest<D2> request){
        mPresenter.doRequest2(request);
    }

    @Override
    public BaseSmartPresenter2<D1,D2, ?> createPresenter() {
        return new BaseSmartPresenter2<>();
    }
}
