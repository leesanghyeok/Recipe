package com.hey.blueberry.recipe;

/**
 * Created by sangeun on 2018-02-11.
 */

public class Food {
    private String title;
    private String material;
    private String imgUrl;
    private String linkUrl;
    private String cooktime;
    private String difficulty;
    private boolean favorite;


    public Food(String name,String detailUrl,String image,String material,String time,String difficulty, boolean favorite){
        this.material=material;
        this.title=name;
        this.imgUrl=image;
        this.linkUrl=detailUrl;
        this.cooktime=time;
        this.difficulty=difficulty;
        this.favorite=Favorite;
    }

    public String getMaterial() {
        return material;
    }

    public String getName() {
        return title;
    }

    public String getImage() { return imgUrl; }

    public String getDetailUrl() {
        return linkUrl;
    }

    public String getTime() {
        return cooktime;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}


