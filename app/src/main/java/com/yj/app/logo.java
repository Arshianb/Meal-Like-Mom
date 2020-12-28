package com.yj.app;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.app.MainPage.MainPage1;
import com.yj.app.base.BaseFragment;
import com.yj.app.login_or_creat_user.Login_or_creat;
import com.yj.app.login_or_creat_user.UserSharedPrefManager;
import com.yj.app.login_or_creat_user.User_in;

import org.json.JSONException;
import org.json.JSONObject;

import static com.chad.library.adapter.base.listener.SimpleClickListener.TAG;

@Puppet
public class logo extends BaseFragment {
    @Override
    protected int getContentView() {
        return R.layout.logo;
    }


    public static logo newInstance() {
        Bundle args = new Bundle();
        logo fragment = new logo();
        fragment.setArguments(args);
        return fragment;
    }

    private UserSharedPrefManager prefManager;
    private String phone_ud_id;
    private ImageView imageView;
    private Login_or_creat fragment;
    private User_in user_in = new User_in();
    private static FrameLayout frameLayout;

    @Override
    protected void init(Bundle savedInstanceState) {


        prefManager = new UserSharedPrefManager(mContext);
        user_in = prefManager.getUser();
        phone_ud_id = MainActivity.UD_ID;

        imageView = (ImageView) findViewById(R.id.appIcon);
        frameLayout = (FrameLayout) findViewById(R.id.fragment1);

        if (Login_or_creat.what_should_logo_do.equals("let him get in")|| !user_in.getUD_ID().equals("")) {
            Log.i(TAG, "init:111 " + user_in.getUD_ID());
            get_in();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    ApiService apiService = new ApiService(mContext);
                    JSONObject requestJsonObject = new JSONObject();
                    try {

                        requestJsonObject.put("give_me_UDID",
                                phone_ud_id);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    apiService.what_is_your_UD_ID(requestJsonObject, new ApiService.whatis() {
                        @Override
                        public void what_is_he(String what_is_he) {

                            if (what_is_he.equals("he is new")) {
                                fragment = Login_or_creat.newInstance(false);
                                Rigger.getRigger(logo.this).showFragment(fragment, R.id.fragment1);
                            }
                            else {
                                if(!what_is_he.equals("")) {
                                    fragment = Login_or_creat.newInstance(true);
                                    Rigger.getRigger(logo.this).showFragment(fragment, R.id.fragment1);

                                }else {
                                    Snackbar.make(findViewById(R.id.atyContent1), "your connection lost you are get in as guest", Snackbar.LENGTH_LONG)
                                            .show();
                                    get_in();
                                }
                            }
                        }
                    });


                }
            }, 1000);
        }
    }


    public static void Animation(String where_this_method_call) {
        switch (where_this_method_call) {
            case "get in":
                TranslateAnimation translateAnimation = new TranslateAnimation(
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_PARENT, -1.0f, Animation.ABSOLUTE, 0);
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new BounceInterpolator());
                frameLayout.startAnimation(translateAnimation);
                break;
            case "get out":
                translateAnimation = new TranslateAnimation(
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0, Animation.RELATIVE_TO_PARENT, 1.0f);
                translateAnimation.setDuration(1000);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new BounceInterpolator());
                frameLayout.startAnimation(translateAnimation);

                break;
            case "move right from x = 0":
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
                translateAnimation.setDuration(250);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                frameLayout.startAnimation(translateAnimation);
                break;

            case "move left from x = 0":

                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
                translateAnimation.setDuration(250);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                frameLayout.startAnimation(translateAnimation);

                break;

            case "move left from x = 1" :
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, 1.0f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
                translateAnimation.setDuration(250);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                frameLayout.startAnimation(translateAnimation);
                break;

            case "move right from x = -1" :
                translateAnimation = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
                translateAnimation.setDuration(250);
                translateAnimation.setFillAfter(true);
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                frameLayout.startAnimation(translateAnimation);
                break;

            case "scale from 1 to 0" :
                ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,0 ,1.0f,0,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setInterpolator(new AccelerateInterpolator());
                scaleAnimation.setDuration(500);
                frameLayout.startAnimation(scaleAnimation);
                break;
                case "scale from 0 to 1" :
                    scaleAnimation = new ScaleAnimation(0, 1.0f, 0 , 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    scaleAnimation.setFillAfter(true);
                    scaleAnimation.setInterpolator(new AccelerateInterpolator());
                    scaleAnimation.setDuration(500);
                    frameLayout.startAnimation(scaleAnimation);
                break;



        }
    }


    private void get_in() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AnimationSet animationSet = new AnimationSet(false);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 10.0f, 1.0f, 10.0f, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);

                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setDuration(500);
                animationSet.setFillAfter(true);
                imageView.startAnimation(animationSet);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MainPage1 fragment = MainPage1.newInstance();
                        Rigger.getRigger(logo.this).startFragment(fragment);
                    }
                }, 500);
            }
        }, 2000);
    }
}
