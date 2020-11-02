package com.dett.mvvmdemo.net;

import com.dett.dettmvvm.mvvm.BaseModel;
import com.dett.dettmvvm.mvvm.BaseRepository;

/**
 * 自定义AppRepository
 *
 * @author wangjian
 * Created on 2020/11/2 15:13
 */
public class AppRepository extends BaseRepository {

    @Override
    protected <Response, Data> BaseModel<Response, Data> getBaseModel() {
        return (BaseModel<Response, Data>) new BaseModel<BaseResponse<Data>, Data>();
    }
}
