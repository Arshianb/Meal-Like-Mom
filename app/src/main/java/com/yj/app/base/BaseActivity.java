package com.yj.app.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yj.app.R;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        init(savedInstanceState);
    }

    @LayoutRes
    protected int getContentView() {
        return R.layout.mainactivity;
    }

    protected abstract void init(Bundle savedInstanceState);
}

