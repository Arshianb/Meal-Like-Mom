package com.yj.app.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.yj.app.R;

@Puppet(containerViewId = R.id.swiper, stickyStack = true)
public abstract class BaseActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        init(savedInstanceState);
    }

    @LayoutRes
    protected int getContentView() {
        return R.layout.swiper;
    }

    protected abstract void init(Bundle savedInstanceState);


}