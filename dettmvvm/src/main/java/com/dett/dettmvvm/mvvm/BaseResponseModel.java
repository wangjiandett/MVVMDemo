/*
 * Copyright (c) 2018.  For more infomation visit https://github.com/wangjiandett/RxDemo
 */
package com.dett.dettmvvm.mvvm;


/**
 * Base model 处理请求，返回响应实体默认使用BaseResponse，供子类继承使用
 * 如果有特殊数据格式不能使用BaseResponse可自行继承BaseModel，并填写响应的response
 *
 * @param <Data> 请求响应BaseResponse中data响应实体
 *
 * <p>
 * Created by：wangjian on 2017/12/21 16:41
 */
public class BaseResponseModel<Data> extends BaseModel<BaseResponse<Data>, Data> {

    @Override
    protected int getSuccessCode() {
        return 0;// 自定义成功响应码
    }
}
