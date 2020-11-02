package com.dett.mvvmdemo.net;

import com.dett.dettmvvm.mvvm.ApiService;
import com.dett.dettmvvm.mvvm.ProgressResultListener;
import com.dett.dettmvvm.mvvm.interceptor.DownloadInterceptor;
import com.dett.dettmvvm.mvvm.interceptor.HeaderParamsInterceptor;
import com.dett.dettmvvm.mvvm.interceptor.UploadInterceptor;

import java.util.Map;

/**
 * data creator helper
 * <p>
 * Created by：wangjian on 2018/8/21 15:11
 */
public class ApiCreator {

    /**
     * base url
     */
    private static final String BASE_URL = "https://www.wanandroid.com/";//"https://travel.shylh1d3.com/wxApi/";

    /**
     * 响应成功code
     */
    public static final int SUCCESS_CODE = 0;

    /**
     * 添加共用header信息，header需要在ApiService前面初始化，否则无法加载mHeadersInterceptor
     */
    private static HeaderParamsInterceptor mHeadersInterceptor = new HeaderParamsInterceptor.Builder().build();

    /**
     * net request config
     */
    private static final ApiService APISERVICE = new ApiService.Builder().interceptor(updateHeadersInterceptor()).baseUrl(BASE_URL).build();

    /**
     * 接口列表
     */
    public static ApiInterfaces apiInterfaces = APISERVICE.getApis(ApiInterfaces.class);


    /**
     * 动态添加请求头，在需要的地方调用更新请求头，如：登录成功时，传入
     */
    public static HeaderParamsInterceptor updateHeadersInterceptor() {
        String headerKey = "Authorization";
        Map<String, String> headerMap = mHeadersInterceptor.getHeaderParamsMap();
        // 此处的header可自定义key，value
        headerMap.put(headerKey, "your token value");
        return mHeadersInterceptor;
    }

    //
    // 由于上传和下载需要自定义拦截器监听进度，防止普通请求出现异常，此处就不使用上面的单例，单独构造一个ApiService
    //

    /**
     * 下载文件接口
     *
     * @param listener 进度监听
     */
    public static ApiInterfaces getDownloadFileInterface(ProgressResultListener listener) {
        ApiService test = new ApiService.Builder()
                .baseUrl(BASE_URL) // BASE_URL https://imtt.dd.qq.com/
                // 监听下载进度，需要设置拦截器
                .netInterceptor(new DownloadInterceptor(listener))
                .interceptor(updateHeadersInterceptor())
                .build();
        return test.getApis(ApiInterfaces.class);
    }

    /**
     * 上传文件接口
     *
     * @param listener 进度监听
     */
    public static ApiInterfaces getUploadFileInterface(ProgressResultListener listener) {
        ApiService test = new ApiService.Builder()
                .baseUrl(BASE_URL)
                // 监听下载进度，需要设置拦截器
                .netInterceptor(new UploadInterceptor(listener))
                .interceptor(updateHeadersInterceptor())
                .build();
        return test.getApis(ApiInterfaces.class);
    }

}
