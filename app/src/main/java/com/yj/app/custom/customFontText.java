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
public class customFontText extends TextView {
    public customFontText(Context context) {
        super(context);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    public customFontText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    public customFontText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    @SuppressLint("NewApi")
    public customFontText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()) {
            setupTextView();
        }
    }

    private void setupTextView() {
        MyApplication myApplication = (MyApplication) getContext().getApplicationContext();
        setTypeface(myApplication.getIranianSansFont());
    }
}
