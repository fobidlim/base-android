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
import android.provider.Settings;
import android.telephony.TelephonyManager;

import com.tfc.library.log.Logger;

/**
 * author @Fobid
 */
public class DeviceInfoUtils {

    private static final String TAG = DeviceInfoUtils.class.getSimpleName();

    /**
     * 기기의 전화번호를 반환하는 메소드.
     */
    public static String getPhoneNumber(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number();
        Logger.d(TAG, "Phone number : " + result);
        return result;
    }

    /**
     * 기기 고유번호와 기기타입을 반환하는 메소드.
     */
    public static String getDeviceIdWithPhoneType(Context context) {
        TelephonyManager manager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String id = manager.getDeviceId();

        if (id == null) {
            id = "NotAvailable";
        }

        switch (manager.getPhoneType()) {
            case TelephonyManager.PHONE_TYPE_NONE:
                return "NONE:" + id;
            case TelephonyManager.PHONE_TYPE_GSM:
                return "GSM:IMEI=" + id;
            case TelephonyManager.PHONE_TYPE_CDMA:
                return "CDMA:MEID/ESN=" + id;
            // for API Level 11 or above
            // case TelephonyManager.PHONE_TYPE_SIP:
            // return "SIP";
            default:
                return "UNKNOWN:ID=" + id;
        }
    }

    /**
     * 기기 고유번호를 반환하는 메소드.</br>공장 초기화를 해도 달라지지 않는다.
     */
    public static String getDeviceId(Context context) {
        TelephonyManager manager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String id = manager.getDeviceId();

        return id;
    }

    /**
     * 기기에 설치된 소프트웨어의 버전을 반환.
     */
    public static String getDeviceSoftwareVersion(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE))
                .getDeviceSoftwareVersion();
        Logger.d(TAG, "Device Software Version : " + result);
        return result;
    }

    /**
     * 네트워크망의 ISO 국가코드 반환. 예: kr, jp 등등.
     */
    public static String getNetworkCountryIso(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE))
                .getNetworkCountryIso();
        Logger.d(TAG, "Network Country Iso : " + result);
        return result;
    }

    /**
     * 네트워크망의 사업자 코드 반환. 예: 45006.
     */
    public static String getNetworkOperator(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE))
                .getNetworkOperator();
        Logger.d(TAG, "Network Operator : " + result);
        return result;
    }

    /**
     * 네트워크망의 사업자 이름 반환. 예: LG U+.
     */
    public static String getNetworkOperatorName(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE))
                .getNetworkOperatorName();
        Logger.d(TAG, "Network Operator Name : " + result);
        return result;
    }

    /**
     * 네트워크 타입을 반환. 예: TelephonyManager.NETWORK_TYPE_GPRS,
     * TelephonyManager.NETWORK_TYPE_EDGE.
     */
    public static int getNetworkType(Context context) {
        int result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getNetworkType();
        Logger.d(TAG, "Network Type : " + result);
        return result;
    }

    /**
     * 기기 타입을 반환. 예: TelephonyManager.PHONE_TYPE_GSM,
     * TelephonyManager.PHONE_TYPE_CDMA.
     */
    public static int getPhoneType(Context context) {
        int result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getPhoneType();
        Logger.d(TAG, "PhonevType : " + result);
        return result;
    }

    /**
     * 유심의 시리얼 번호를 반환.
     */
    public static String getSimSerialNumber(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE))
                .getSimSerialNumber();
        Logger.d(TAG, "Sim Serial Number : " + result);
        return result;
    }

    /**
     * 유심의 상태를 반환. 예: TelephonyManager.SIM_STATE_ABSENT(유심이 없음).
     */
    public static int getSimState(Context context) {
        int result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getSimState();
        Logger.d(TAG, "Sim State : " + result);
        return result;
    }

    /**
     * 기기의 IMSI값을 반환.
     */
    public static String getSubscriberId(Context context) {
        String result = ((TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
        Logger.d(TAG, "SubscribervId : " + result);
        return result;
    }

    /**
     * android.os.Build.BOARD의 값을 반환. 이게 기기의 모델명일 때도 있고, 다른 값이 들어있을 때도 있다.
     */
    public static String getBuildBoard() {
        Logger.d(TAG, "Build Board : " + android.os.Build.BOARD);
        return android.os.Build.BOARD;
    }

    /**
     * android.os.Build.VERSION.RELEASE의 값을 반환.
     */
    public static String getBuildVersion() {
        Logger.d(TAG, "Build Version : " + android.os.Build.VERSION.RELEASE);
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * android.os.Build.VERSION.SDK_INT의 값을 반환.
     */
    public static int getBuildVersionCode() {
        Logger.d(TAG, "Build Version : " + android.os.Build.VERSION.SDK_INT);
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * android.os.Build.BRAND의 값을 반환.
     */
    public static String getBuildBrand() {
        Logger.d(TAG, "Build Brand : " + android.os.Build.BRAND);
        return android.os.Build.BRAND;
    }

    /**
     * android.os.Build.CPU_ABI의 값을 반환.
     */
    public static String getBuildCpuAbi() {
        Logger.d(TAG, "Build CPU ABI : " + android.os.Build.CPU_ABI);
        return android.os.Build.CPU_ABI;
    }

    /**
     * android.os.Build.CPU_ABI2의 값을 반환.
     */
    public static String getBuildCpuAbi2() {
        Logger.d(TAG, "Build CPU ABI2 : " + android.os.Build.CPU_ABI2);
        return android.os.Build.CPU_ABI2;
    }

    /**
     * android.os.Build.DEVICE의 값을 반환.
     */
    public static String getBuildDevice() {
        Logger.d(TAG, "Build Device : " + android.os.Build.DEVICE);
        return android.os.Build.DEVICE;
    }

    /**
     * android.os.Build.DISPLAY의 값을 반환.
     */
    public static String getBuildDisplay() {
        Logger.d(TAG, "Build Display : " + android.os.Build.DISPLAY);
        return android.os.Build.DISPLAY;
    }

    /**
     * android.os.Build.FINGERPRINT의 값을 반환.
     */
    public static String getBuildFingerPrint() {
        Logger.d(TAG, "Build Finger Print : " + android.os.Build.FINGERPRINT);
        return android.os.Build.FINGERPRINT;
    }

    /**
     * android.os.Build.HOST의 값을 반환.
     */
    public static String getBuildHost() {
        Logger.d(TAG, "Build Host : " + android.os.Build.HOST);
        return android.os.Build.HOST;
    }

    /**
     * android.os.Build.ID의 값을 반환.
     */
    public static String getBuildId() {
        Logger.d(TAG, "Build ID : " + android.os.Build.ID);
        return android.os.Build.ID;
    }

    /**
     * android.os.Build.MANUFACTURER의 값을 반환.
     */
    public static String getBuildManufacturer() {
        Logger.d(TAG, "Build Manufacturer : " + android.os.Build.MANUFACTURER);
        return android.os.Build.MANUFACTURER;
    }

    /**
     * android.os.Build.MODEL의 값을 반환.
     */
    public static String getBuildModel() {
        Logger.d(TAG, "Build Model : " + android.os.Build.MODEL);
        return android.os.Build.MODEL;
    }

    /**
     * android.os.Build.PRODUCT의 값을 반환.
     */
    public static String getBuildProduct() {
        Logger.d(TAG, "Build Product : " + android.os.Build.PRODUCT);
        return android.os.Build.PRODUCT;
    }

    /**
     * android.os.Build.TAGS의 값을 반환.
     */
    public static String getBuildTags() {
        Logger.d(TAG, "Build Tags : " + android.os.Build.TAGS);
        return android.os.Build.TAGS;
    }

    /**
     * android.os.Build.TIME의 값을 반환.
     */
    public static long getBuildTime() {
        Logger.d(TAG, "Build Time : " + android.os.Build.TIME);
        return android.os.Build.TIME;
    }

    /**
     * android.os.Build.TYPE의 값을 반환.
     */
    public static String getBuildType() {
        Logger.d(TAG, "Build Type : " + android.os.Build.TYPE);
        return android.os.Build.TYPE;
    }

    /**
     * android.os.Build.USER의 값을 반환.
     */
    public static String getBuildUser() {
        Logger.d(TAG, "Build User : " + android.os.Build.USER);
        return android.os.Build.USER;
    }

    /**
     * android.os.Build.USER의 값을 반환.</br>공장 초기화를 해도 달라지지 않는다.
     */
    @SuppressLint("NewApi")
    public static String getBuildSerial() {
        if (android.os.Build.VERSION.SDK_INT < 9) {
            Logger.d(TAG, "Build serial requires API level 9");
            return null;
        } else {
            Logger.d(TAG, "Build serial : " + android.os.Build.SERIAL);
            return android.os.Build.SERIAL;
        }
    }

    /**
     * Settings.Secure.ANDROID_ID의 값을 반환.</br>공장 초기화를 하면 달라진다.
     */
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    /**
     * 기기의 고유식별자를 반환한다.</br>공장 초기화를 해도 달라지지 않는다.
     */
    public static String getFactoryFixedDeviceUniqueId(Context context) {
        return getBuildSerial() != null ? getBuildSerial()
                : getDeviceId(context);
    }

    /**
     * 기기의 고유식별자를 반환한다.</br>공장 초기화를 하면 달라진다.
     */
    public static String getFactoryFlexibleDeviceUniqueId(Context context) {
        String androidId = getAndroidId(context);
        return androidId == null ? null
                : getFactoryFixedDeviceUniqueId(context)
                + getAndroidId(context);
    }
}