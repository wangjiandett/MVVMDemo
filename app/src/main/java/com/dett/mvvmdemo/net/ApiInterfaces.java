package com.dett.mvvmdemo.net;

import com.dett.mvvmdemo.bean.GetResponse;
import com.dett.mvvmdemo.bean.PostRequest;
import com.dett.mvvmdemo.bean.PostResponse;
import com.dett.mvvmdemo.bean.UploadResp;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 统一管理网络请求接口
 *
 * post请求的时候
 * 注解介绍：@File，@FieldMap参数提交的类型是'application/x-www-form-urlencoded'
 * 注解介绍：@Body参数提交的类型是'application/json'
 * 官方介绍：https://square.github.io/retrofit/
 */
public interface ApiInterfaces {

    /**
     * 上传文件接口
     */
    @POST("image/upload")
    Observable<BaseResponse<UploadResp>> uploadFile(@Body RequestBody body);

    /**
     * 下载文件接口
     */
    // "16891/apk/55259F8EF9824AF1BF80106B0E00BCD1.apk"
    // "dmusic/NeteaseCloudMusic_Music_official_7.3.0.1599039901.apk"

    //  默认情况下，Retrofit在处理结果前会将服务器端的Response全部读进内存。
    //  如果服务器端返回的是一个非常大的文件，则容易发生oom。
    //  使用@Streaming的主要作用就是把实时下载的字节就立马写入磁盘，而不用把整个文件读入内存
    //
    @Streaming // 下载文件需要添加
    @GET("blogimgs/e8faab6b-ecb1-4bc2-af96-f7e5039032b3.apk")
    Observable<ResponseBody> downloadFile();

    @Streaming // 下载文件需要添加
    @GET
    Observable<ResponseBody> downloadFile2(@Url String url);


    // retrofit自定义请求头
    // @Headers(value = {"Content-type:application/x-www-form-urlencoded;charset=UTF-8"})
    // @Headers(value = {"Content-type:application/json;charset=UTF-8"})

    // 单个get查询字段
    @GET("banner/json")
    Observable<BaseResponse<List<GetResponse>>> getBanners(@Query("type") String type);

    // 多个get查询字段
    @GET("cardBanner/list")
    Observable<BaseResponse<List<GetResponse>>> getBanners(@QueryMap Map<String, String> map);

    // post 请求
    @POST("login")
    Observable<BaseResponse<PostResponse>> testPost(@Body PostRequest request);


}
