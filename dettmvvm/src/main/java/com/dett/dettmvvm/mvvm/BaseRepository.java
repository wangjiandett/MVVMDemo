package com.dett.dettmvvm.mvvm;

import androidx.lifecycle.MutableLiveData;

import io.reactivex.Observable;

/**
 * Repository request data
 * <p>
 * Created by：wangjian on 2018/8/21 15:11
 */
public abstract class BaseRepository {

    protected <Response, Data> MutableLiveData<ResponseData<Data>> request(Observable<Response> observable) {
        return request(null, observable);
    }

    protected <Response, Data> MutableLiveData<ResponseData<Data>> request(Object requestParams, Observable<Response> observable) {
        BaseModel<Response, Data> baseMode = getBaseModel();
        return baseMode.request(requestParams, observable);
    }

    protected <Response, Data> BaseModel<Response, Data> getBaseModel() {
        return new BaseModel<Response, Data>();
    }

}
