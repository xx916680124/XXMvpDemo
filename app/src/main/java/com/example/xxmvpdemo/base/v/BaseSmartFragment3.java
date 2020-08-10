package com.example.xxmvpdemo.base.v;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.xxmvpdemo.base.p.BaseSmartPresenter2;
import com.example.xxmvpdemo.base.p.BaseSmartPresenter3;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;

import java.lang.reflect.ParameterizedType;

/**
 * author : xx
 * time : 2020/8/8 10:28
 * describe :
 **/
public abstract class BaseSmartFragment3<D1,D2,D3> extends BaseMvpFragment<BaseSmartPresenter3<D1,D2,D3,?>> implements IBaseSmartView3<D1,D2,D3,BaseSmartPresenter3<D1,D2,D3,?>>{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Class<D1> aClass= (Class<D1>) superClass.getActualTypeArguments()[0];
        Class<D2> aClass2= (Class<D2>) superClass.getActualTypeArguments()[1];
        Class<D3> aClass3= (Class<D3>) superClass.getActualTypeArguments()[2];
        mPresenter.setType(aClass);
    }
    public void doRequest3(MvpRequest<D3> request){
        mPresenter.doRequest3(request);
    }

    @Override
    public BaseSmartPresenter3<D1,D2,D3, ?> createPresenter() {
        return new BaseSmartPresenter3<>();
    }
}
