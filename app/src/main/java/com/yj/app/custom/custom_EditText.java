package com.yj.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.yj.app.base.MyApplication;


@SuppressLint("AppCompatCustomView")
public class custom_EditText extends EditText {


    public custom_EditText(Context context) {
        super(context);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    public custom_EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    public custom_EditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    @SuppressLint("NewApi")
    public custom_EditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    private void setupcheckbutton() {
        MyApplication myApplication = (MyApplication) getContext().getApplicationContext();
        setTypeface(myApplication.getenglisgfont());
    }
}
