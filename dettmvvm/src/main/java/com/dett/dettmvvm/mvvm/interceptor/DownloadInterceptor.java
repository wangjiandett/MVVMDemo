package com.dett.dettmvvm.mvvm.interceptor;


import com.dett.dettmvvm.mvvm.ProgressResponseBody;
import com.dett.dettmvvm.mvvm.ProgressResultListener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 下载文件拦截，监听下载进度
 */
public class DownloadInterceptor implements Interceptor {

    /**
     * 下载进度回调
     */
    private ProgressResultListener downloadListener;

    public DownloadInterceptor(ProgressResultListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        Request.Builder requestBuilder = request.newBuilder();
//        requestBuilder.addHeader("Accept-Encoding", "identity");

        Response response = chain.proceed(request);
        return response.newBuilder().body(
                new ProgressResponseBody(response.body(), downloadListener)).build();
    }
}
