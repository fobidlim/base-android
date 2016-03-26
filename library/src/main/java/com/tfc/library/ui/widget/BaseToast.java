package com.tfc.library.ui.widget;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Fobid on 2016. 3. 25..
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
