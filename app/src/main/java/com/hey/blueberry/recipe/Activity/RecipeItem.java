package com.hey.blueberry.recipe.Activity;

/**
 * Created by daeyo on 2018-02-20.
 */

public class RecipeItem {
    private String title;
    private String material;
    private String difficulty;
    private String cooktime;
    private String  imgUrl;
    private String linkUrl;

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    private boolean favorite;

    public boolean isFavorite() {
        return favorite;
    }

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

    public String getTitle() {
        return this.title;
    }

    public String getMaterial() {
        return material;
    }

    RecipeItem( String title, String material, String cooktime, String difficulty, String imgUrl, String linkUrl, boolean favorite){
        this.title=title;
        this.material=material;
        this.difficulty=difficulty;
        this.cooktime=cooktime;
        this.imgUrl=imgUrl;
        this.linkUrl=linkUrl;
        this.favorite=favorite;
    }
}
