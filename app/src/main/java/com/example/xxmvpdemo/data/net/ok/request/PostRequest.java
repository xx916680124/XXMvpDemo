package com.example.xxmvpdemo.data.net.ok.request;

public class PostRequest<T> extends MvpRequest<T> {
    public PostRequest(String url) {
        super(url);
    }

    public PostRequest() {
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }
}
