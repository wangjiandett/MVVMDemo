package com.dett.dettmvvm.mvvm;

/**
 * IBaseResponse
 *
 * @author wangjian
 * Created on 2020/11/2 14:24
 */
public abstract class IBaseResponse<T> {

    public abstract int getCode();

    public abstract String getMsg();

    public abstract T getData();

    public abstract boolean isSuccess();

}
