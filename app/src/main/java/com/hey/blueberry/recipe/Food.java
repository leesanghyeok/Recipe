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
    private int favorite;
    private int materialNum;

    public Food(String name,String detailUrl,String image,String material,String time,String difficulty,int favorite,int materialNum){
        this.material=material;
        this.title=name;
        this.imgUrl=image;
        this.linkUrl=detailUrl;
        this.cooktime=time;
        this.difficulty=difficulty;
        this.favorite = favorite;
        this.materialNum = materialNum;
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

    public int getFavorite() { return favorite; }

    public int getMaterialNum() { return materialNum; }

}
