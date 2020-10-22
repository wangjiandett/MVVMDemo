package com.dett.mvvmdemo.repository;


import androidx.lifecycle.MutableLiveData;

import com.dett.dettmvvm.mvvm.BaseRepository;
import com.dett.dettmvvm.mvvm.BaseResponseModel;
import com.dett.dettmvvm.mvvm.ResponseData;
import com.dett.mvvmdemo.bean.GetResponse;
import com.dett.mvvmdemo.net.ApiCreator;

import java.util.List;

public class SwipeRepository extends BaseRepository {

    BaseResponseModel<List<GetResponse>> bannerModel;

    /**
     * 加载banners
     */
    public MutableLiveData<ResponseData<List<GetResponse>>> getBanners(String type) {
        bannerModel = getBaseResponseModel();
        return bannerModel.request(ApiCreator.apiInterfaces.getBanners(type));
    }

    /**
     * 取消请求
     */
    public void cancelBanners() {
        if (bannerModel != null) {
            bannerModel.cancel();
        }
    }

    /**
     * 加载banners
     */
    public MutableLiveData<ResponseData<List<GetResponse>>> getBanners2(String type) {
        return requestBR(new Object(), ApiCreator.apiInterfaces.getBanners(type));
    }


}
