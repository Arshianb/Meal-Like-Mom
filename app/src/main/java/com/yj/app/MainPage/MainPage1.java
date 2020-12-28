package com.yj.app.MainPage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;

import com.iammert.library.readablebottombar.ReadableBottomBar;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yj.app.MainPage.Category.Data_category;
import com.yj.app.MainPage.Search.Search;
import com.yj.app.MainPage.Category.category;
import com.yj.app.MainPage.Category.category_ithem;
import com.yj.app.MainPage.Favorite.Favorit;
import com.yj.app.MainPage.Home.Home;
import com.yj.app.MainPage.User.User;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class MainPage1 extends BaseFragment {


    public static MainPage1 newInstance() {
        Bundle args = new Bundle();
        MainPage1 fragment = new MainPage1();
        fragment.setArguments(args);
        return fragment;
    }

    private static final String TAG = "";
    private ReadableBottomBar readableBottomBar ;
    private List<Fragment> fragmentList;

    @Override
    protected int getContentView() {
        return R.layout.activity_main2;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        fragmentList = new ArrayList<>();
        fragmentList.add(new Home());
        fragmentList.add(new category());
        fragmentList.add(new Search());
        fragmentList.add(new Favorit());
        fragmentList.add( User.newInstance());

        readableBottomBar = (ReadableBottomBar) findViewById(R.id.buttombar);
//        FrameLayout fragment = (FrameLayout) findViewById(R.id.fragment);


        List <category_ithem> categoryDatas = new ArrayList<>();

            for (int i = 0; i <= 5; i++) {
                category_ithem category_ithem = new category_ithem();
                switch (i) {
                    case 0:
                        category_ithem.setDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.morning, null));
                        category_ithem.setCat_title("Breackfast");
                        break;

                    case 1:
                        category_ithem.setDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.afternoon, null));
                        category_ithem.setCat_title("Lunch");
                        break;

                    case 2:
                        category_ithem.setDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.night, null));
                        category_ithem.setCat_title("Dinner");
                        break;

                    case 3:
                        category_ithem.setDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.cook, null));
                        category_ithem.setCat_title("?");
                        break;

                    case 4:
                        category_ithem.setDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.desert, null));
                        category_ithem.setCat_title("Desser");
                        break;

                    case 5:
                        category_ithem.setDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.before_dinner, null));
                        category_ithem.setCat_title("Before dinner");
                        break;
                }

                categoryDatas.add(category_ithem);

        }
            Data_category.setsampleData(categoryDatas);


        Rigger.getRigger(this).showFragment(fragmentList.get(0),R.id.fragment);


        readableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int index) {
                switch (index){
                    case 0 :
                        home(index);
                        break;
                    case 1 :
                        Category(index);
                        break;
                    case 2 :
                        search(index);
                        break;
                    case 3:
                        Favorite(index);
                        break;
                    case 4:
                        profile(index);
                        break;
                }

            }
        });


    }

    private void home(int i ){
        Rigger.getRigger(this)
                .showFragment(fragmentList.get(i) ,R.id.fragment );

    }
    private void search(int i){
        Rigger.getRigger(this)
                .showFragment(fragmentList.get(i) , R.id.fragment );

    }
    private void Category(int i){
        Rigger.getRigger(this)
                .showFragment(fragmentList.get(i), R.id.fragment );

    }
    private void Favorite(int i){
        Rigger.getRigger(this)
                .showFragment(fragmentList.get(i), R.id.fragment );

    }
    private void profile(int i){
        Rigger.getRigger(this)
                .showFragment(fragmentList.get(i), R.id.fragment );

    }



}
