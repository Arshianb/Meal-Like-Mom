package com.yj.app;


import android.os.Bundle;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.app.base.BaseActivity;
//@Swiper

@Puppet(containerViewId = R.id.atyContent ,stickyStack = true)
public class MainActivity extends BaseActivity {

    public static String UD_ID;

    @Override
    protected void init(Bundle savedInstanceState) {

        Rigger.enableDebugLogging(true);

//        Rigger.getRigger(this).getSwipeLayout().setShadowDrawable(new int[]{
//                R.drawable.swiper_shadow_left, R.drawable.swiper_shadow_right,
//                R.drawable.swiper_shadow_top, R.drawable.swiper_shadow_bottom
//        });

        UD_ID = android.provider.Settings.System.getString(super.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);

        logo fragment = logo.newInstance();
        Rigger.getRigger(this).showFragment(fragment, R.id.atyContent);


    }
}
