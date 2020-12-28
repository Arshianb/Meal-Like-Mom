package com.yj.app.foods;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class getData {


    private static List<Status> posts1 = new ArrayList<>();

    public static void setPosts(List<Status> Statuses){
        posts1= Statuses;
    }

    public static List<Status> getSampleData() {
        return posts1;
    }
}
