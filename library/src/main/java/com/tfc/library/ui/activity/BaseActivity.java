/*
 * Copyright Fobid. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tfc.library.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tfc.library.log.Logger;

/**
 * author @Fobid
 */
public abstract class BaseActivity extends AppCompatActivity {

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.d(getActivityTag(), "onCreate");
        ActivityManager.getInstance().addActivity(this, getActivityTag());
        super.onCreate(savedInstanceState);
    }


    @CallSuper
    @Override
    protected void onDestroy() {
        Logger.d(getActivityTag(), "onDestroy");
        ActivityManager.getInstance().removeActivity(this, getActivityTag());
        super.onDestroy();
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz) {
        startActivity(clazz, null, false);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz, @Nullable Bundle bundle) {
        startActivity(clazz, bundle, false);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz, boolean finish) {
        startActivity(clazz, null, finish);
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz, @Nullable Bundle bundle, boolean finish) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);

        if (finish) {
            finish();
        }
    }

    public void startActivity(@NonNull Class<? extends Activity> clazz, int flags, @Nullable Bundle bundle, boolean finish) {
        Intent intent = new Intent(this, clazz);
        intent.addFlags(flags);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);

        if (finish) {
            finish();
        }
    }

    protected abstract String getActivityTag();
}
