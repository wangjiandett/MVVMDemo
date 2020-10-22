package com.dett.dettmvvm.mvvm;

import androidx.lifecycle.MutableLiveData;

import io.reactivex.Observable;

/**
 * Repository request data
 * <p>
 * Created by：wangjian on 2018/8/21 15:11
 */
public class BaseRepository {

    protected <Response, Data> MutableLiveData<ResponseData<Data>> request(Observable<Response> observable) {
        return request(null, observable);
    }

    protected <Response, Data> MutableLiveData<ResponseData<Data>> request(Object requestParams, Observable<Response> observable) {
        BaseModel<Response, Data> baseMode = getBaseModel();
        return baseMode.request(requestParams, observable);
    }

    protected <Data> MutableLiveData<ResponseData<Data>> requestBR(Observable<BaseResponse<Data>> observable) {
        return requestBR(null, observable);
    }

    protected <Data> MutableLiveData<ResponseData<Data>> requestBR(Object requestParams, Observable<BaseResponse<Data>> observable) {
        BaseResponseModel<Data> baseMode = getBaseResponseModel();
        return baseMode.request(requestParams, observable);
    }

    /**
     * 获取
     *
     * @param <Response>
     * @param <Data>
     * @return
     */
    protected <Response, Data> BaseModel<Response, Data> getBaseModel() {
        return new BaseModel<Response, Data>();
    }

    protected <Data> BaseResponseModel<Data> getBaseResponseModel() {
        return new BaseResponseModel<Data>();
    }
}
