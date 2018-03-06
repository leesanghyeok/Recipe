package com.hey.blueberry.recipe.Activity;

/**
 * Created by daeyo on 2018-02-20.
 */

public class RecipeStep_item {

    int stepImage;
    String step;

    public int getStepImage() {
        return this.stepImage;
    }


    public String getStep() {
        return step;
    }

    RecipeStep_item(int stepImage, String step){
        this.stepImage=stepImage;
        this.step=step;
    }
}
