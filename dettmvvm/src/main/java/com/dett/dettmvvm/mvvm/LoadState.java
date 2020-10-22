package com.dett.dettmvvm.mvvm;

/**
 * loading status
 * <p>
 * Created by：wangjian on 2018/8/21 15:34
 */
public enum  LoadState {
    /**
     * load fail
     */
    FAIL(-1, "FAIL"),
    /**
     * load success
     */
    SUCCESS(1, "SUCCESS"),
    /**
     * load cancel
     */
    CANCEL(2, "CANCEL");

    

    private String tipMsg;
    private int status;
    
    LoadState(int status, String tipMsg) {
        this.status = status;
        this.tipMsg = tipMsg;
    }

    public LoadState setTipMsg(String tipMsg){
        this.tipMsg = tipMsg;
        return this;
    }

    public LoadState setStatus(int status){
        this.status = status;
        return this;
    }

    public String getTipMsg() {
        return tipMsg;
    }

    public int getStatus() {
        return status;
    }
}