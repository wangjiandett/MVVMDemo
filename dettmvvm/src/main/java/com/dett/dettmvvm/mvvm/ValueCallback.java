package com.dett.dettmvvm.mvvm;

/**
 * value callback
 * <p>
 * Created by：wangjian on 2017/12/21 11:12
 */
public interface ValueCallback<T> extends ProgressResultListener {

    /**
     * 显示进度条回调
     */
    void onShowProgress();

    /**
     * 隐藏进度条回调
     */
    void onHideProgress();

    /**
     * 响应成功结果回调
     *
     * @param response
     */
    void onSuccess(T response);

    /**
     * 响应失败回调
     *
     * @param code 错误码
     * @param msg 失败提示
     */
    void onFail(int code, String msg);

    /**
     * 取消请求回调
     */
    void onCancel();
    
}
