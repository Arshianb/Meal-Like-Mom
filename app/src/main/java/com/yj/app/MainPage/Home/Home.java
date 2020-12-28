package com.yj.app.MainPage.Home;

import android.os.Bundle;
import android.view.animation.Animation;

import com.yj.app.R;
import com.yj.app.base.BaseFragment;
import com.yj.app.utils.AnimationHelper;

public class Home extends BaseFragment {

    public static Home newInstance() {
        Bundle args = new Bundle();
        Home fragment = new Home();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.home;
    }

    @Override
    protected void init(Bundle savedInstanceState) {



    }

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        if(enter)
//            return AnimationHelper.createRotate3dEnterAnimation();
//        else
//            return AnimationHelper.createRotate3dExitAnimation();
//    }

}
