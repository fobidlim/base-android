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
package com.tfc.library.ui.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * author @Fobid
 */
public class BaseToast {
    private static BaseToast mInstance;
    private Context mContext;
    private Toast mCurrentToast;

    private BaseToast(Context context) {
        this.mContext = context;
    }

    public static void init(Context context) {
        mInstance = new BaseToast(context);
    }

    public static void showText(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }

    public static void showText(String text) {
        if (mInstance.mContext == null) {
            throw new IllegalStateException("BaseToast is not initialized: Call BaseToast.init(Context) first.");
        }
        if (mInstance.mCurrentToast != null) {
            mInstance.mCurrentToast.cancel();
        }

        mInstance.mCurrentToast = Toast.makeText(mInstance.mContext, text, Toast.LENGTH_LONG);
        mInstance.mCurrentToast.show();
    }
}
