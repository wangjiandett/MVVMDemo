package com.dett.dettmvvm.mvvm.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 自定义header参数
 *
 * @author wangjian
 * Created on 2020/9/9 14:53
 */
public class HeaderParamsInterceptor implements Interceptor {

    private Map<String, String> headerParamsMap = new HashMap<>();
    private List<String> headerLinesList = new ArrayList<>();

    private HeaderParamsInterceptor() {
    }

    public List<String> getHeaderLinesList() {
        return headerLinesList;
    }

    public Map<String, String> getHeaderParamsMap() {
        return headerParamsMap;
    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        // process header params inject
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (headerParamsMap.size() > 0) {
            for (Map.Entry<String, String> entry : headerParamsMap.entrySet()) {
                headerBuilder.add(entry.getKey(), entry.getValue());
            }
        }

        // process header line params inject
        if (headerLinesList.size() > 0) {
            for (String line : headerLinesList) {
                headerBuilder.add(line);
            }
        }

        requestBuilder.headers(headerBuilder.build());
        // process header params end

        request = requestBuilder.build();
        return chain.proceed(request);
    }

    public static class Builder {

        HeaderParamsInterceptor interceptor;

        public Builder() {
            interceptor = new HeaderParamsInterceptor();
        }

        public Builder addHeaderParam(String key, String value) {
            interceptor.headerParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParamsMap(Map<String, String> headerParamsMap) {
            interceptor.headerParamsMap.putAll(headerParamsMap);
            return this;
        }

        public Builder addHeaderLine(String headerLine) {
            int index = headerLine.indexOf(":");
            if (index == -1) {
                throw new IllegalArgumentException("Unexpected header: " + headerLine);
            }
            interceptor.headerLinesList.add(headerLine);
            return this;
        }

        public Builder addHeaderLinesList(List<String> headerLinesList) {
            for (String headerLine : headerLinesList) {
                int index = headerLine.indexOf(":");
                if (index == -1) {
                    throw new IllegalArgumentException("Unexpected header: " + headerLine);
                }
                interceptor.headerLinesList.add(headerLine);
            }
            return this;
        }

        public HeaderParamsInterceptor build() {
            return interceptor;
        }

    }
}