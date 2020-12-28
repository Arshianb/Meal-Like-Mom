package com.yj.app.base;

import android.app.Application;
import android.graphics.Typeface;

public class MyApplication extends Application {
    private static Typeface iranianSansFont;
    private static Typeface iranianSansFont1;
    private static Typeface english_sans;
    @Override
    public void onCreate() {
        super.onCreate();
        iranianSansFont=Typeface.createFromAsset(getAssets(), "fonts/iranian_sans.ttf");
        iranianSansFont1=Typeface.createFromAsset(getAssets(), "fonts/iranian_sans_2.TTF");
        english_sans=Typeface.createFromAsset(getAssets(), "fonts/english_fonts.TTF");

    }

    public static Typeface getIranianSansFont(){
        return iranianSansFont;
    }
    public Typeface getIranianSansFont1(){
        return iranianSansFont1;
    }
    public Typeface getenglisgfont(){
        return english_sans;
    }
}
