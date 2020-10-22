package com.dett.dettmvvm.utils;

import android.os.Build;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 日志管理文件
 * <p>
 * Created by：wangjian on 2017/12/22 14:40
 */
public class LogUtils {

    private static final String TAG = "LogUtils";
    private static Locale mLogLocale = Locale.CHINA;

    private static final String WRITE_LOG_ENABLE = "write_log_enable";

    /**
     * 日志文件生成日期
     */
    private static SimpleDateFormat LOGFILE = new SimpleDateFormat("yyyyMMdd", mLogLocale);//HHmmss
    /**
     * 日志文件写入时间
     */
    private static SimpleDateFormat LOGTIME = new SimpleDateFormat("HH:mm:ss ", mLogLocale);

    /**
     * 默认可打印日志，后期根据是否release版本控制是否打印日志
     *
     * @return
     */
    public static boolean isLoggable() {
        return true;
    }

    /**
     * 拼接日志内容
     *
     * @param msg 日志内容
     * @return
     */
    private static String getLog(String msg) {
        return getFileLineMethod() + msg;
    }

    public static void v(String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.v(TAG, log);
        }
    }

    public static void v(String tag, String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.v(tag, log);
        }
    }

    public static void d(Object msg){
        d(GsonHelper.toJson(msg));
    }

    public static void d(String tag, String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.d(tag, log);
        }
    }

    public static void d(String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.d(TAG, log);
        }
    }

    public static void i(String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.i(TAG, log);
        }
    }

    public static void i(String tag, String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.i(tag, log);
        }
    }

    public static void w(String tag, String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.w(tag, log);
        }
    }

    public static void w(String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.w(TAG, log);
        }
    }


    public static void e(String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.e(TAG, log);
        }
    }

    public static void e(String tag, String msg) {
        if (isLoggable()) {
            String log = getLog(msg);
            Log.e(tag, log);
        }
    }

    private static String getFileLineMethod() {
        StackTraceElement[] traceElements = ((new Exception()).getStackTrace());
        String method = "";
        if(traceElements.length > 4){
            StackTraceElement traceElement = traceElements[4];
            method = "[" +//
                    traceElement.getFileName() +//
                    " | " +//
                    traceElement.getLineNumber() +//
                    " | " +//
                    traceElement.getMethodName() +//
                    "] ";
        }

        return method;
    }


    /**
     * 保存手机信息到日志中
     * 此方法在app打开的时候写入一次即可
     */
    public static void writePhoneInfo2File() {

        String phoneInfo = "\n==============System Info==============\n" + "\n Product: " + Build.PRODUCT;
        phoneInfo += "\n CPU_ABI: " + Build.CPU_ABI;
        phoneInfo += "\n TAGS: " + Build.TAGS;
        phoneInfo += "\n VERSION_CODES.BASE: " + Build.VERSION_CODES.BASE;
        phoneInfo += "\n 手机型号: " + Build.MODEL;
        phoneInfo += "\n SDK版本: " + Build.VERSION.SDK;
        phoneInfo += "\n Android系统版本号: " + Build.VERSION.RELEASE;
        phoneInfo += "\n DEVICE: " + Build.DEVICE;
        phoneInfo += "\n DISPLAY: " + Build.DISPLAY;
        phoneInfo += "\n 手机厂商: " + Build.BRAND;
        phoneInfo += "\n BOARD: " + Build.BOARD;
        phoneInfo += "\n FINGERPRINT: " + Build.FINGERPRINT;
        phoneInfo += "\n ID: " + Build.ID;
        phoneInfo += "\n MANUFACTURER: " + Build.MANUFACTURER;
        phoneInfo += "\n USER: " + Build.USER;
        phoneInfo += "\n 手机当前系统语言: " + Locale.getDefault().getLanguage();

        Log.d(TAG, phoneInfo);
    }


}
