package com.dett.mvvmdemo.net;

import com.dett.dettmvvm.mvvm.IBaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Net response
 * <p>
 * Created by：wangjian on 2017/12/20 16:12
 */
public class BaseResponse<T> implements IBaseResponse<T> {

    public T data;
    @SerializedName("errorCode")
    public int code;
    @SerializedName("errorMsg")
    public String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return code == ApiCreator.SUCCESS_CODE; // 自定义请求成功码
    }

}
