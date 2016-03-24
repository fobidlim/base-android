package com.tfc.library.log;

import android.util.Log;

import com.tfc.library.Config;

/**
 * Created by Fobid on 2016. 3. 25..
 */
public class Logger {
    public static int v(String tag, String msg) {
        return Log.v(tag, msg);
    }

    public static int v(String tag, String msg, Throwable tr) {
        return Log.v(tag, msg, tr);
    }

    public static int e(String tag, String msg) {
        return Log.e(tag, msg);
    }

    public static int e(String tag, String msg, Throwable tr) {
        return Log.e(tag, msg, tr);
    }

    public static int w(String tag, String msg) {
        return Log.w(tag, msg);
    }

    public static int w(String tag, String msg, Throwable tr) {
        return Log.w(tag, msg, tr);
    }

    public static int i(String tag, String msg) {
        return Log.i(tag, msg);
    }

    public static int i(String tag, String msg, Throwable tr) {
        return Log.i(tag, msg, tr);
    }

    public static int d(String tag, String msg) {
        return !Config.isDebug() ? -1 : Log.d(tag, msg);
    }

    public static int d(String tag, String msg, Throwable tr) {
        return !Config.isDebug() ? -1 : Log.d(tag, msg, tr);
    }
}
