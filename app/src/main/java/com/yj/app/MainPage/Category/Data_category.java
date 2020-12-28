package com.yj.app.MainPage.Category;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Data_category {


    private static Context context ;
    public Data_category(Context context) {
        this.context = context ;

    }
    private static List<category_ithem> categoryDatas = new ArrayList<>();

    public static void setsampleData (List <category_ithem> data){
        categoryDatas = data;

    }

    public static List<category_ithem> getSampleData1() {
        return categoryDatas;
    }
}
