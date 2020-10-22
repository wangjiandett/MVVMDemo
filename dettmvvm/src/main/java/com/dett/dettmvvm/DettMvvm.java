package com.dett.dettmvvm;

import android.app.Application;
import android.content.Context;

/**
 * Describe
 *
 * @author wangjian
 * Created on 2020/10/19 14:30
 */
public class DettMvvm {

    private Context mContext;

    private volatile static DettMvvm instance = null;

    public static DettMvvm getInstance() {
        if (instance == null) {
            synchronized (DettMvvm.class) {
                if (instance == null) {
                    instance = new DettMvvm();
                }
            }
        }
        return instance;
    }

    public static void init(Application application){
        DettMvvm config = getInstance();
        if(config != null){
            config.mContext = application;
        }
    }

    public Context getContext() {
        return mContext;
    }
}
