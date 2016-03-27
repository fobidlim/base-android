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
import android.content.ClipData;
import android.content.Context;

/**
 * author @Fobid
 */
public class ClipboardUtils {

    /**
     * Clipboard에 text를 저장해주는 메소드.
     *
     * @param text
     *            Clipboard에 저장할 text.
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static void copyText(Context context, String text) {
        if (android.os.Build.VERSION.SDK_INT < 11) {
            android.text.ClipboardManager cm = (android.text.ClipboardManager) context
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(text);
        } else {
            android.content.ClipboardManager cm = (android.content.ClipboardManager) context
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", text);
            cm.setPrimaryClip(clip);
        }
    }
}