package com.hey.blueberry.recipe;

/**
 * Created by sangeun on 2018-02-11.
 */

public class Food {
    private String material;
    private String name;
    private String image;
    private String detailUrl;
    private String time;
    private String difficulty;

    public Food(String name,String detailUrl,String image,String material,String time,String difficulty){
        this.material=material;
        this.name=name;
        this.image=image;
        this.detailUrl=detailUrl;
        this.time=time;
        this.difficulty=difficulty;
    }

    public String getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public String getTime() {
        return time;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
