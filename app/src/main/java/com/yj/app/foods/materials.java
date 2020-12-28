package com.yj.app.foods;

import java.util.ArrayList;
import java.util.List;

public class materials {

    private List<String> material_title = new ArrayList<>();
    private List<String> material_color = new ArrayList<>();
    private int food_id ;

    public materials() {
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }


    public List<String> getMaterial_title() {
        return material_title;
    }

    public void setMaterial_title(List<String> material_title) {
        this.material_title = material_title;
    }

    public List<String> getMaterial_color() {
        return material_color;
    }

    public void setMaterial_color(List<String> material_color) {
        this.material_color = material_color;
    }
}
