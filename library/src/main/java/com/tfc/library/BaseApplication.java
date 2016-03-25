package com.tfc.library;

import android.app.Application;

import com.tfc.library.ui.widget.BaseToast;

/**
 * Created by Fobid on 2016. 3. 25..
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        BaseToast.init(this);

        if (BuildConfig.DEBUG) {
            new Config() {
            };
        }
    }
}
