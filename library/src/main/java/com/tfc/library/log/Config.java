package com.tfc.library.log;

/**
 * Created by Fobid on 2016. 3. 25..
 */
public abstract class Config {
    static boolean DEBUG = false;

    public Config() {
    }

    public static final boolean isDebug() {
        return DEBUG;
    }
}