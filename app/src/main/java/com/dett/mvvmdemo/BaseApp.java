package com.dett.mvvmdemo;


import androidx.multidex.MultiDexApplication;

import com.dett.dettmvvm.DettMvvm;

public class BaseApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DettMvvm.init(this);
    }
}
