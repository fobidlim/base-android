package com.tfc.library.ui.activity;

import android.app.Activity;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Fobid on 2016. 3. 25..
 */
public class ActivityManager {
    private static volatile ActivityManager mInstance;
    private final Map<String, Stack<Activity>> mTaggedActivityMap;
    private final Stack<Activity> mActivityStack;

    private ActivityManager() {
        mTaggedActivityMap = new Hashtable<>();
        mActivityStack = new Stack<>();
    }

    public static ActivityManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityManager.class) {
                mInstance = new ActivityManager();
            }
        }
        return mInstance;
    }

    public Stack<Activity> getActivityStack() {
        Stack<Activity> activityStack = new Stack<>();
        activityStack.addAll(mActivityStack);

        return activityStack;
    }

    public Stack<Activity> getActivityStack(String tag) {
        if (tag == null) {
            tag = "";
        }
        Stack<Activity> activityStack = new Stack<>();
        activityStack.addAll(mTaggedActivityMap.get(tag));

        return activityStack;
    }

    public void addActivity(Activity activity, String tag) {
        if (mActivityStack.indexOf(activity) == -1) {
            if (tag == null) {
                tag = "";
            }

            mActivityStack.push(activity);
            if (mTaggedActivityMap.get(tag) == null) {
                mTaggedActivityMap.put(tag, new Stack<Activity>());
            }

            mTaggedActivityMap.get(tag).add(activity);
        }
    }

    public void removeActivity(String tag) {
        if (tag == null) {
            tag = "";
        }

        if (mTaggedActivityMap.get(tag) != null) {
            Stack<Activity> activityStack = mTaggedActivityMap.get(tag);

            for (Activity activity : activityStack) {
                mActivityStack.remove(activity);
            }

            mTaggedActivityMap.remove(tag);
        }
    }

    public void removeActivity(Activity activity, String tag) {
        if (tag == null) {
            tag = "";
        }

        if (mTaggedActivityMap.get(tag) != null) {
            if (mTaggedActivityMap.get(tag).remove(activity)) {
                mActivityStack.remove(activity);
            }
        }
    }

    public void finishActivity(String tag) {
        if (tag == null) {
            tag = "";
        }

        Stack<Activity> activityStack = mTaggedActivityMap.get(tag);

        if (activityStack != null) {
            for (Activity activity : activityStack) {
                activity.finish();
            }
            removeActivity(tag);
        }
    }

    public void finishAllActivity() {
        for (Activity activity : mActivityStack) {
            activity.finish();
        }
        mActivityStack.clear();
        mTaggedActivityMap.clear();
    }

    public Activity getTopActivity() {
        return mActivityStack.get(0);
    }
}
