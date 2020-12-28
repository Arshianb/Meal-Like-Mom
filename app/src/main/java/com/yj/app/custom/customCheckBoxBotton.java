package com.yj.app.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.yj.app.base.MyApplication;


@SuppressLint("AppCompatCustomView")
public class customCheckBoxBotton extends CheckBox {
    public customCheckBoxBotton(Context context) {
        super(context);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    public customCheckBoxBotton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    public customCheckBoxBotton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()){
            setupcheckbutton();
        }
    }

    @SuppressLint("NewApi")
    public customCheckBoxBotton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
