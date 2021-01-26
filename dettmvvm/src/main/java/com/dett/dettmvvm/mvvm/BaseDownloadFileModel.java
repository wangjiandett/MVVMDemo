package com.dett.dettmvvm.mvvm;

import com.dett.dettmvvm.exception.ExceptionHandle;
import com.dett.dettmvvm.exception.ResponseException;
import com.dett.dettmvvm.utils.LogUtils;
import com.dett.dettmvvm.utils.Utils;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * 文件下载 base model
 */
public abstract class BaseDownloadFileModel implements ProgressResultListener {

    private Disposable mDisposable;
    private boolean isDownloading;
    protected ValueCallback<File> mCallback;

    public BaseDownloadFileModel() {
    }

    public BaseDownloadFileModel(ValueCallback<File> mCallback) {
        this.mCallback = mCallback;
    }

    /**
     * 监听下载进度，需要设置拦截器
     *
     * @param url 下载地址
     */
    protected abstract Observable<ResponseBody> getDownloadObservable(String url);

    /**
     * 下载文件
     *
     * @param destFile 文件保存位置
     */
    public void download(String url, final File destFile) {
        getDownloadObservable(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .map(new ResultFilter(destFile))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<File>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        LogUtils.d("download start");
                        mDisposable = d;
                        isDownloading = true;
                    }

                    @Override
                    public void onNext(File file) {
                        LogUtils.d("download file success: " + file.getAbsoluteFile());
                        isDownloading = false;
                        onSuccess(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.d(e);
                        isDownloading = false;
                        ResponseException exception = ExceptionHandle.handleException(e);
                        onFail(exception.code, exception.message);
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.d("onComplete");
                    }
                });
    }

    public void cancel() {
        if (this.mDisposable != null && !this.mDisposable.isDisposed()) {
            this.mDisposable.dispose();
            isDownloading = false;
        }
    }

    public boolean isDownloading() {
        return isDownloading;
    }

    private static class ResultFilter implements Function<ResponseBody, File> {

        private File desFile;

        public ResultFilter(File desFile) {
            this.desFile = desFile;
        }

        @Override
        public File apply(ResponseBody responseBody) throws Exception {
            if (desFile != null) {
                Utils.writeInputStream2File(responseBody.byteStream(), desFile.getAbsolutePath());
            }
            return desFile;
        }
    }


    /**
     * the success callback
     *
     * @param file the success value
     */
    protected abstract void onSuccess(File file);

    /**
     * the fail callback
     *
     * @param msg the fail code
     * @param msg the fail message
     */
    protected abstract void onFail(int code, String msg);

}
