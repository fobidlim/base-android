package com.tfc.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tfc.library.log.Logger;

/**
 * Created by Fobid on 2016. 3. 22..
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.d(getActivityTag(), "onCreate");
        ActivityManager.getInstance().addActivity(this, getActivityTag());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        Logger.d(getActivityTag(), "onDestroy");
        ActivityManager.getInstance().removeActivity(this, getActivityTag());
        super.onDestroy();
    }

    public void startActivity(Class<Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    protected abstract String getActivityTag();
}
