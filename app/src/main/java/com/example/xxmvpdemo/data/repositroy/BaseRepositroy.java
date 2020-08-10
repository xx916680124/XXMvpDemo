package com.example.xxmvpdemo.data.repositroy;

import com.example.xxmvpdemo.base.IBaseCallBack;
import com.example.xxmvpdemo.base.m.IBaseMode;
import com.example.xxmvpdemo.data.entity.HttpResult;
import com.example.xxmvpdemo.data.net.ok.DataService;
import com.example.xxmvpdemo.data.net.ok.request.MvpRequest;
import com.example.xxmvpdemo.data.net.ok.response.MvpResponse;
import com.example.xxmvpdemo.utils.ParameterizedTypeImpl;
import com.google.gson.Gson;
import com.trello.rxlifecycle4.LifecycleProvider;
import com.trello.rxlifecycle4.RxLifecycle;
import com.trello.rxlifecycle4.android.ActivityEvent;
import com.trello.rxlifecycle4.android.FragmentEvent;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * author : xx
 * time : 2020/8/8 9:01
 * describe :
 **/
public class BaseRepositroy implements IBaseMode {
    Consumer empty = o -> {
    };

    @Override
    public <T> void doRequest(LifecycleProvider lifecycleProvider, MvpRequest<T> request, IBaseCallBack<T> callBack) {
        doRequest(lifecycleProvider, request, empty, callBack);
    }

    public <T> void doRequest(LifecycleProvider lifecycleProvider, MvpRequest<T> request, Consumer<MvpResponse<T>> consumer, IBaseCallBack<T> callBack) {
        switch (request.getRequestMethod()) {
            case GET:
                doObserver(lifecycleProvider, request, DataService.getService().doGet(request.getUrl(), request.getParams(), request.getHeaders()), consumer, callBack);
                break;
            case POST:
                doObserver(lifecycleProvider, request, DataService.getService().doPost(request.getUrl(), request.getParams(), request.getHeaders()), consumer, callBack);
                break;
        }
    }

    private <T> void doObserver(LifecycleProvider lifecycleProvider, MvpRequest<T> request, Observable<String> observable, Consumer<MvpResponse<T>> consumer, IBaseCallBack<T> callBack) {
        if (request.getType() == null && callBack != null) {

            Type[] callbackT = callBack.getClass().getGenericInterfaces();

            ParameterizedType parameterizedType = (ParameterizedType) callbackT[0];

            request.setType((Class<T>) parameterizedType.getActualTypeArguments()[0]);

        }
        @NonNull Observable<MvpResponse<T>> observable1 = observable.map(jsonToData(request))
                .doOnNext(consumer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        if (lifecycleProvider instanceof RxAppCompatActivity){
            observable1 = observable1.compose(RxLifecycle.bindUntilEvent(lifecycleProvider.lifecycle(), ActivityEvent.DESTROY));
        }else{
            observable1 =  observable1.compose(RxLifecycle.bindUntilEvent(lifecycleProvider.lifecycle(), FragmentEvent.DESTROY));
        }
        observable1.subscribe(new Observer<MvpResponse<T>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                if (request.isEnableCancel()&&callBack!=null){
                    callBack.onStart(d);
                }
            }

            @Override
            public void onNext(@NonNull MvpResponse<T> data) {
                if (callBack != null) {
                    callBack.onResult(data);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                if (callBack!=null){
                    callBack.onResult(new MvpResponse<T>().message(e.getMessage()));
                }
            }

            @Override
            public void onComplete() {

            }
        });

    }

    private <T> Function<String, MvpResponse<T>> jsonToData(MvpRequest<T> request) {
        return new Function<String, MvpResponse<T>>() {
            @Override
            public MvpResponse<T> apply(String s) throws Throwable {
                Gson gson = new Gson();
                ParameterizedTypeImpl type = new ParameterizedTypeImpl(HttpResult.class, new Type[]{request.getType()});
                HttpResult<T> data = gson.fromJson(s, type);
                if (data.getCode() == 1) {
                    if (data.getData() != null) {
                        return new MvpResponse<T>().setData(data.getData()).setCode(data.getCode());
                    }else {
                        return new MvpResponse<T>().setCode(data.getCode()).message("服务器发生异常，数据为空");
                    }
                }else {
                    return new MvpResponse<T>().setCode(data.getCode()).message(data.getMessage());
                }
            }
        };
    }
}
