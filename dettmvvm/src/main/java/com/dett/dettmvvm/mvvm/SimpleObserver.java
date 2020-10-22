package com.dett.dettmvvm.mvvm;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

public abstract class SimpleObserver<Response> implements Observer<ResponseData<Response>> {

    @Override
    public void onChanged(@Nullable ResponseData<Response> responseData) {
        if (responseData != null) {
            switch (responseData.mStatus) {
                case SUCCESS:
                    onSuccess(responseData.request, responseData.response);
                    break;
                case FAIL:
                    onFailure(responseData.mStatus.getTipMsg());
                    break;
                case CANCEL:
                    onCancel();
                    break;
            }
        }
    }

    public abstract void onSuccess(Object request, Response response);

    public abstract void onFailure(String msg);

    public void onCancel() {
    }
}
