package com.dett.dettmvvm.mvvm;

import com.google.gson.annotations.SerializedName;

/**
 * Net response
 * <p>
 * Created by：wangjian on 2017/12/20 16:12
 */
public class BaseResponse<T> {

    public T data;
    @SerializedName("errorCode")
    public int code;
    @SerializedName("errorMsg")
    public String msg;
    
}
