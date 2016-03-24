package com.tfc.library.util;

import java.util.List;

/**
 * Created by Fobid on 2016. 3. 25..
 */
public class Utils {
    public static boolean isArrEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isArrEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }
}
