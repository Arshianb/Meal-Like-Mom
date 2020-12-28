package com.yj.app.MainPage.Favorite;

import android.os.Bundle;

import com.yj.app.R;
import com.yj.app.base.BaseFragment;

public class Favorit extends BaseFragment {

    public static Favorit newInstance() {
        Bundle args = new Bundle();
        Favorit fragment = new Favorit();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.favorit;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }


}
