package com.dett.mvvmdemo.viewmodel;

import com.dett.dettmvvm.mvvm.BaseDownloadFileModel;
import com.dett.dettmvvm.mvvm.ValueCallback;
import com.dett.mvvmdemo.net.ApiCreator;

import java.io.File;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Describe
 *
 * @author wangjian
 * Created on 2020/10/19 11:10
 */
public class DownloadModel extends BaseDownloadFileModel {

    public DownloadModel(ValueCallback<File> mCallback) {
        super(mCallback);
    }

    @Override
    protected Observable<ResponseBody> getDownloadObservable(String url) {
        return ApiCreator.getDownloadFileInterface(this).downloadFile2(url);
    }

    @Override
    protected void onSuccess(File value) {
        mCallback.onSuccess(value);
    }

    @Override
    protected void onFail(String msg) {
        mCallback.onFail(msg);
    }

    @Override
    public void onProgressChange(int percent) {
        mCallback.onProgressChange(percent);
    }
}
