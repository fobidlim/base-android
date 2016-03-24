package com.tfc.library;

import android.app.Application;

/**
 * Created by Fobid on 2016. 3. 25..
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            new Config() {
            };
        }
    }
}
