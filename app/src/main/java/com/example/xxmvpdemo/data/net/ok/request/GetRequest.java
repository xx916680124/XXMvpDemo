package com.example.xxmvpdemo.data.net.ok.request;

public class GetRequest<T> extends MvpRequest<T> {

    public GetRequest() {
    }

    public GetRequest(String url) {
        super(url);
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.GET;
    }
}
