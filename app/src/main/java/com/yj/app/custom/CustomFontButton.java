package com.yj.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.yj.app.base.MyApplication;


/**
 * Created by Saeed shahini on 9/23/2016.
 */
@SuppressLint("AppCompatCustomView")
public class CustomFontButton extends Button {
    public CustomFontButton(Context context) {
        super(context);
        if (!isInEditMode()){
            setupButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()){
            setupButton();
        }
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()){
            setupButton();
        }
    }

    @SuppressLint("NewApi")
    public CustomFontButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()){
            setupButton();
        }
    }
    private void setupButton() {
        MyApplication myApplication = (MyApplication) getContext().getApplicationContext();
        setTypeface(myApplication.getenglisgfont());
    }
}
