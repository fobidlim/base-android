package com.tfc.library.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Fobid on 2016. 3. 22..
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityManager.getInstance().addActivity(this, getActivityTag());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getInstance().removeActivity(this, getActivityTag());
        super.onDestroy();
    }

    protected abstract String getActivityTag();
}
