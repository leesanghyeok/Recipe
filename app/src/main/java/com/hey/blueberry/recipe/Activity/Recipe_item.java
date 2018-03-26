package com.hey.blueberry.recipe.Activity;

/**
 * Created by daeyo on 2018-02-20.
 */

public class Recipe_item {
    private int image;
    private String title;
    private String material;
    private String difficulty;
    private String cooktime;
    private String  imgUrl;
    private String linkUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCooktime() {
        return cooktime;
    }

    public int getImage() {
        return this.image;
    }

    public String getTitle() {
        return this.title;
    }

    public String getMaterial() {
        return material;
    }

    Recipe_item(int image, String title, String material, String cooktime, String difficulty, String imgUrl, String linkUrl){
        this.image=image;
        this.title=title;
        this.material=material;
        this.difficulty=difficulty;
        this.cooktime=cooktime;
        this.imgUrl=imgUrl;
        this.linkUrl=linkUrl;
    }
}
