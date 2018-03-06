package com.hey.blueberry.recipe.Activity;

/**
 * Created by daeyo on 2018-02-20.
 */

public class Recipe_item { int image;
    String title;
    String material;

    public int getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMaterial() {
        return material;
    }

    Recipe_item(int image, String title, String material){
        this.image=image;
        this.title=title;
        this.material=material;
    }
}
