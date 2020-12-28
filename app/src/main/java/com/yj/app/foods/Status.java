package com.yj.app.foods;

import android.graphics.drawable.Drawable;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.yalantis.filter.model.FilterModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Status  implements MultiItemEntity, FilterModel  {
    private String title;
    private String date;
    private int id ;
    private String image_url;
    private String content;
    private int ItemType=2;
    private String video_url;
    private List<String> material_title = new ArrayList<>() ;
    private List<String> material_color = new ArrayList<>() ;
    private List<String> material_count = new ArrayList<>() ;
    private  List<String> material_type = new ArrayList<>() ;
    private int price ;
    private int post_rate ;
    private int view_count ;
    private Drawable header_image;
    private String description;




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItemType(int ItemType) {
        this.ItemType = ItemType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public Drawable getHeader_image() {
        return header_image;
    }

    public void setHeader_image(Drawable header_image) {
        this.header_image = header_image;
    }

    @Override
    public int getItemType() {
        return ItemType;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPost_rate() {
        return post_rate;
    }

    public void setPost_rate(int post_rate) {
        this.post_rate = post_rate;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

//    public List<String> getMaterial_title() {
//        return material_title;
//    }

    public void setMaterial_title(List<String> material_title) {
        this.material_title = material_title;
    }

    public List<String> getMaterial_count() {
        return material_count;
    }

    public void setMaterial_count(List<String> material_count) {
        this.material_count = material_count;
    }

    public List<String> getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(List<String> material_type) {
        this.material_type = material_type;
    }

    public List<String> getMaterial_title() {
        return material_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMaterial_color() {
        return material_color;
    }

    public void setMaterial_color(List<String> material_color) {
        this.material_color = material_color;
    }

    @NotNull
    @Override
    public String getText() {
        return title;
    }
}
