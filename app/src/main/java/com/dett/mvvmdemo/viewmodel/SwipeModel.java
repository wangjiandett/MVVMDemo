package com.dett.mvvmdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.dett.dettmvvm.mvvm.BaseViewModel;
import com.dett.dettmvvm.mvvm.ResponseData;
import com.dett.mvvmdemo.bean.GetResponse;
import com.dett.mvvmdemo.repository.SwipeRepository;

import java.util.List;

/**
 * 加载swipe data的viewModel
 * <p>
 * Created by：wangjian on 2018/8/21 15:11
 */
public class SwipeModel extends BaseViewModel<SwipeRepository> {

    public MutableLiveData<ResponseData<List<GetResponse>>> getBanners(String type) {
        return mRepository.getBanners(type);
    }

    public void cancelBanners(){
        mRepository.cancelBanners();
    }

    public MutableLiveData<ResponseData<List<GetResponse>>> getBanners2(String type) {
        return mRepository.getBanners2(type);
    }
}
