package com.dett.mvvmdemo.repository;


import androidx.lifecycle.MutableLiveData;

import com.dett.dettmvvm.mvvm.ResponseData;
import com.dett.mvvmdemo.bean.GetResponse;
import com.dett.mvvmdemo.net.ApiCreator;
import com.dett.mvvmdemo.net.AppRepository;

import java.util.List;

public class SwipeRepository extends AppRepository {

    /**
     * 加载banners
     */
    public MutableLiveData<ResponseData<List<GetResponse>>> getBanners(String type) {
        return request(ApiCreator.apiInterfaces.getBanners(type));
    }

    /**
     * 加载banners
     */
    public MutableLiveData<ResponseData<List<GetResponse>>> getBanners2(String type) {
        return request(new Object(), ApiCreator.apiInterfaces.getBanners(type));
    }


}
