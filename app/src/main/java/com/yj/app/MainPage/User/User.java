package com.yj.app.MainPage.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.app.MainActivity;
import com.yj.app.MainPage.MainPage1;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;
import com.yj.app.utils.AnimationHelper;

public class User extends BaseFragment {

    public static User newInstance() {
        Bundle args = new Bundle();
        User fragment = new User();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.user_page;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_upload_video1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), uploadPost.class);
                startActivity(intent);
            }
        });



    }

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        if(enter)
//        return AnimationHelper.createRotate3dEnterAnimation();
//        else
//            return AnimationHelper.createRotate3dExitAnimation();
//    }
}
