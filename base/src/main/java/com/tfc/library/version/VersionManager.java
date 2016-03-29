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
package com.tfc.library.version;

import android.content.Context;

import com.tfc.library.SharedPreferencesHelper;
import com.tfc.library.util.PackageInfoUtils;

/**
 * author @Fobid
 */
public class VersionManager {

    private static final String FILE_NAME_VERSION = "version_manager_shared_preferences";

    private static final String KEY_APP_VERSION_CODE = "app_version_code";
    private static final String KEY_APP_VERSION_NAME = "app_version_name";

//    /**
//     * 저장되어있는 AppVersionCode를 가져온다.
//     *
//     * @return 저장되어있는 AppVersionCode. 저장된 데이터가 없을 경우 null
//     */
    public static int getAppVersionCode(Context context) {
        return SharedPreferencesHelper.getInt(context, FILE_NAME_VERSION,
                KEY_APP_VERSION_CODE);
    }

//    /**
//     * 저장되어있는 AppVersionName를 가져온다.
//     *
//     * @return 저장되어있는 AppVersionName. 저장된 데이터가 없을 경우 null
//     */
    public static String getAppVersionName(Context context) {
        return SharedPreferencesHelper.getString(context, FILE_NAME_VERSION,
                KEY_APP_VERSION_NAME);
    }

//    /**
//     * App Version을 저장한다. 추후에 앱의 버전이 바뀔 때 특정 작업을 수행하고 싶을 때 사용한다.
//     */
    public static void setAppVersion(Context context) {
        SharedPreferencesHelper.setInt(context, FILE_NAME_VERSION,
                KEY_APP_VERSION_CODE, PackageInfoUtils.getVersionCode(context));
        SharedPreferencesHelper.setString(context, FILE_NAME_VERSION,
                KEY_APP_VERSION_NAME, PackageInfoUtils.getVersionName(context));
    }

//    /**
//     * 저장된 App Version 정보를 지운다.
//     */
    public static void rmAppVersion(Context context) {
        SharedPreferencesHelper.rm(context, FILE_NAME_VERSION,
                KEY_APP_VERSION_CODE);
        SharedPreferencesHelper.rm(context, FILE_NAME_VERSION,
                KEY_APP_VERSION_NAME);
    }

//    /**
//     * 파라미터로 입력한 버전과 현재 어플리케이션의 버전을 비교한다. 버전은 숫자와 점만으로 구분한다.
//     *
//     * @param recentVersion
//     *            비교할 버전
//     * @return 버전이 몇번째부터 낮아지는지 반환한다. 현재 앱의 버전이 하위 버전이 아닐 경우 0을 반환한다. 오류 발생시 -1을
//     *         반환한다
//     * @example1 현재 앱의 버전이 1.3.0이고 입력된 버전이 1.4.1일 경우 첫번째 자리는 둘 다 1로 동일하고 두번째
//     *           자리에서 현재 앱의 버전이 입력된 버전보다 작기 때문에 2가 반환된다
//     * @example2 현재 앱의 버전이 1.3.0이고 입력된 버전이 1.3.0 혹은 1.2.x 혹은 그 아래일 경우 0이 반환된다
//     * @example3 현재 앱의 버전을 알 수 없거나(Manifest에 미기입) 입력된 버전이 올바르지 않은 경우(숫자와 점으로 구분할
//     *           수 없음) -1이 반환된다
//     */
    public static int checkVersion(Context context, String recentVersion) {
        try {
            String[] recentVersionParticle = recentVersion.replaceAll(
                    "[^0-9\\.]", "").split("\\.");
            String[] thisAppVersionParticle = PackageInfoUtils
                    .getVersionName(context).replaceAll("[^0-9\\.]", "")
                    .split("\\.");

            for (int i = 0; i < Math.min(recentVersionParticle.length,
                    thisAppVersionParticle.length); i++) {
                int recent = Integer.parseInt(recentVersionParticle[i]);
                int thisApp = Integer.parseInt(thisAppVersionParticle[i]);
                if (thisApp > recent) {
                    break;
                } else if (recent > thisApp) {
                    return i + 1;
                }
            }
            return 0;
        } catch (Exception e) {
            return -1;
        }
    }
}