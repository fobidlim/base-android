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
package com.tfc.library.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.tfc.library.log.Logger;

/**
 * author @Fobid
 */
public class DisplayUtils {

    private static final String TAG = DisplayUtils.class.getSimpleName();

    /**
     * 화면의 넓이를 반환한다.
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static int getWidth(Context context) {
        int result = 0;
        Display display = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if (android.os.Build.VERSION.SDK_INT >= 13) {
            Point p = new Point(0, 0);
            display.getSize(p); // API Level 13
            result = p.x;
        } else {
            result = display.getWidth();
        }
        Logger.i(TAG, "getWidth: result=" + result);

        return result;
    }

    /**
     * 화면의 높이를 반환한다.
     *
     * @see 안드로이드의 상태바까지 합한 높이가 반환됨
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static int getHeight(Context context) {
        int result = 0;
        Display display = ((WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if (android.os.Build.VERSION.SDK_INT >= 13) {
            Point p = new Point(0, 0);
            display.getSize(p); // API Level 13
            result = p.y;
        } else {
            result = display.getHeight();
        }
        Logger.i(TAG, "getHeight: result=" + result);

        return result;
    }

    /**
     * 상태바의 높이를 반환한다.
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        Logger.i(TAG, "getStatusBarHeight: result=" + result);

        return result;
    }

    /**
     * 상태바를 제외한 화면의 높이를 반환한다.
     */
    public static int getHeightExcludeStatusBarHeight(Context context) {
        return getHeight(context) - getStatusBarHeight(context);
    }

    /**
     * 픽셀값을 dp값으로 변환해주는 메소드.
     *
     * @param pixel
     *            dp로 변환할 픽셀값
     * @return dp로 변환된 값
     */
    public static float pxToDp(float pixel) {
        return pixel / Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * 픽셀값을 sp값으로 변환해주는 메소드.
     *
     * @param pixel
     *            sp로 변환할 픽셀값
     * @return sp로 변환된 값
     */
    public static float pxToSp(float pixel) {
        return pixel / Resources.getSystem().getDisplayMetrics().scaledDensity;
    }

    /**
     * dp값을 픽셀값으로 변환해주는 메소드.
     *
     * @param dp
     *            픽셀로 변환할 dp값
     * @return 픽셀로 변환된 값
     */
    public static float dpToPx(float dp) {
        return dp * Resources.getSystem().getDisplayMetrics().density;
    }
}