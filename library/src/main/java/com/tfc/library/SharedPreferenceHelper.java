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
package com.tfc.library;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.tfc.library.log.Logger;

/**
 * author @Fobid
 */
public class SharedPreferencesHelper {

    private static final String TAG = SharedPreferencesHelper.class
            .getSimpleName();

    /**
     * String 데이터를 저장한다.
     *
     * @param fileName
     *            데이터를 저장할 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param value
     *            데이터의 값
     */
    public static void setString(Context context, String fileName, String key,
                                 String value) {
        if (context == null) {
            Logger.e(TAG, "setString: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * boolean 데이터를 저장한다.
     *
     * @param fileName
     *            데이터를 저장할 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param value
     *            데이터의 값
     */
    public static void setBoolean(Context context, String fileName, String key,
                                  boolean value) {
        if (context == null) {
            Logger.e(TAG, "setBoolean: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * int 데이터를 저장한다.
     *
     * @param fileName
     *            데이터를 저장할 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param value
     *            데이터의 값
     */
    public static void setInt(Context context, String fileName, String key,
                              int value) {
        if (context == null) {
            Logger.e(TAG, "setInt: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * long 데이터를 저장한다.
     *
     * @param fileName
     *            데이터를 저장할 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param value
     *            데이터의 값
     */
    public static void setLong(Context context, String fileName, String key,
                               long value) {
        if (context == null) {
            Logger.e(TAG, "setLong: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * float 데이터를 저장한다.
     *
     * @param fileName
     *            데이터를 저장할 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param value
     *            데이터의 값
     */
    public static void setFloat(Context context, String fileName, String key,
                                float value) {
        if (context == null) {
            Logger.e(TAG, "setFloat: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * 저장된 String 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 null 반환
     */
    public static String getString(Context context, String fileName, String key) {
        if (context == null) {
            Logger.e(TAG, "getString: Parameter context is null");
            return null;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getString(key, null);
    }

    /**
     * 저장된 String 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param defValue
     *            저장된 데이터가 없을 경우 반환할 값
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 defValue 반환
     */
    public static String getString(Context context, String fileName,
                                   String key, String defValue) {
        if (context == null) {
            Logger.e(TAG, "getString: Parameter context is null");
            return null;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getString(key, defValue);
    }

    /**
     * 저장된 boolean 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 false 반환
     */
    public static boolean getBoolean(Context context, String fileName,
                                     String key) {
        if (context == null) {
            Logger.e(TAG, "getBoolean: Parameter context is null");
            return false;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }

    /**
     * 저장된 boolean 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param defValue
     *            저장된 데이터가 없을 경우 반환할 값
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 defValue 반환
     */
    public static boolean getBoolean(Context context, String fileName,
                                     String key, boolean defValue) {
        if (context == null) {
            Logger.e(TAG, "getBoolean: Parameter context is null");
            return false;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getBoolean(key, defValue);
    }

    /**
     * 저장된 int 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 -1 반환
     */
    public static int getInt(Context context, String fileName, String key) {
        if (context == null) {
            Logger.e(TAG, "getInt: Parameter context is null");
            return 0;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getInt(key, -1);
    }

    /**
     * 저장된 int 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param defValue
     *            저장된 데이터가 없을 경우 반환할 값
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 defValue 반환
     */
    public static int getInt(Context context, String fileName, String key,
                             int defValue) {
        if (context == null) {
            Logger.e(TAG, "getInt: Parameter context is null");
            return 0;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getInt(key, defValue);
    }

    /**
     * 저장된 long 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 -1 반환
     */
    public static long getLong(Context context, String fileName, String key) {
        if (context == null) {
            Logger.e(TAG, "getLong: Parameter context is null");
            return 0;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getLong(key, -1);
    }

    /**
     * 저장된 long 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param defValue
     *            저장된 데이터가 없을 경우 반환할 값
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 defValue 반환
     */
    public static long getLong(Context context, String fileName, String key,
                               long defValue) {
        if (context == null) {
            Logger.e(TAG, "getLong: Parameter context is null");
            return 0;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getLong(key, defValue);
    }

    /**
     * 저장된 float 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 -1 반환
     */
    public static float getFloat(Context context, String fileName, String key) {
        if (context == null) {
            Logger.e(TAG, "getLong: Parameter context is null");
            return 0;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getFloat(key, -1);
    }

    /**
     * 저장된 float 데이터를 가져온다.
     *
     * @param fileName
     *            데이터를 가져올 공간의 이름
     * @param key
     *            데이터의 식별자
     * @param defValue
     *            저장된 데이터가 없을 경우 반환할 값
     * @return 가져온 데이터. 저장된 데이터가 없을 경우 defValue 반환
     */
    public static float getFloat(Context context, String fileName, String key,
                                 float defValue) {
        if (context == null) {
            Logger.e(TAG, "getLong: Parameter context is null");
            return 0;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        return prefs.getFloat(key, defValue);
    }

    /**
     * 저장된 데이터를 삭제한다.
     *
     * @param fileName
     *            삭제할 데이터가 저장되어 있는 공간의 이름
     * @param key
     *            데이터의 식별자
     */
    public static void rm(Context context, String fileName, String key) {
        if (context == null) {
            Logger.e(TAG, "rm: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 특정 공간의 저장된 데이터를 모두 삭제한다.
     *
     * @param fileName
     *            삭제할 공간의 이름
     */
    public static void clear(Context context, String fileName) {
        if (context == null) {
            Logger.e(TAG, "rmAll: Parameter context is null");
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(fileName,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }
}