package com.jkb.fragment.swiper;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * This class is used to manage {@link AppCompatActivity} and only used by {@link SwipeLayout}.
 *
 * @author JingYeoh
 * <a href="mailto:yangjing9611@foxmail.com">Email me</a>
 * <a href="https://github.com/justkiddingbaby">Github</a>
 * <a href="http://blog.justkiddingbaby.com">Blog</a>
 * @since Aug 1,2018
 */
class SwipeActivityManager {

    private Stack<AppCompatActivity> mActivityStack;

    private static volatile SwipeActivityManager sInstance = null;

    private SwipeActivityManager() {
        mActivityStack = new Stack<>();
    }

    /**
     * Returns the instance of SwipeManager.
     */
    static SwipeActivityManager getInstance() {
        if (sInstance == null) {
            synchronized (SwipeActivityManager.class) {
                if (sInstance == null) {
                    sInstance = new SwipeActivityManager();
                }
            }
        }
        return sInstance;
    }

    private void addToStack(@NonNull AppCompatActivity activity) {
        if (mActivityStack.contains(activity)) {
            return;
        }
        mActivityStack.add(activity);
    }

    private void removeFromStack(@NonNull AppCompatActivity activity) {
        mActivityStack.remove(activity);
    }

    @NonNull
    Stack<AppCompatActivity> getActivityStack() {
        return mActivityStack;
    }
}
