package com.yj.app.MainPage.Search;

import android.support.annotation.NonNull;

import com.yalantis.filter.model.FilterModel;

public class Tag  implements FilterModel {

    private String text;
    private int color;

    public Tag(String text, int color) {
        this.text = text;
        this.color = color;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



}
