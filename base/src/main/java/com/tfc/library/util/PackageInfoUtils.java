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

import android.content.Context;
import android.content.pm.PackageInfo;

import com.tfc.library.log.Logger;

/**
 * author @Fobid
 */
public class PackageInfoUtils {

    private static final String TAG = PackageInfoUtils.class.getSimpleName();

    /**
     * 어플리케이션의 VersionName을 반환해주는 함수 예를 들어 1.3.9 같은 버전 이름을 반환해준다.
     *
     * @return 어플리케이션의 VersionName
     */
    public static String getVersionName(Context context) {
        String result = null;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            result = pi.versionName;
        } catch (Exception e) {
            Logger.e(TAG, "getVersionName", e);
        }
        return result;
    }

    /**
     * 어플리케이션의 VersionCode를 반환해주는 함수 예를 들어 12 같은 버전 코드을 반환해준다.
     *
     * @return 어플리케이션의 VersionCode
     */
    public static int getVersionCode(Context context) {
        int result = 0;
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            result = pi.versionCode;
        } catch (Exception e) {
            Logger.e(TAG, "getVersionCode", e);
        }
        return result;
    }
}