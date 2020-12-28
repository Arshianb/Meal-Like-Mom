package com.yj.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


import com.yj.app.base.MyApplication;

/**
 * Created by Saeed shahini on 9/23/2016.
 */
@SuppressLint("AppCompatCustomView")
public class customTextView1 extends TextView {
    public customTextView1(Context context) {
        super(context);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    public customTextView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    public customTextView1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    @SuppressLint("NewApi")
    public customTextView1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    private void setupTextView() {
        MyApplication myApplication = (MyApplication) getContext().getApplicationContext();
        setTypeface(myApplication.getIranianSansFont1());
    }
}
