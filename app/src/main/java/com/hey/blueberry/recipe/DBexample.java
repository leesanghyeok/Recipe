package com.hey.blueberry.recipe;

import android.content.Context;

/**
 * Created by sangeun on 2018-05-21.
 */

public class DBexample  {
    Context context;
    public DBexample(Context context) {
        this.context = context;
    }

    void example(){
        DBHelper db=new DBHelper(context);
        UserDBHelper userDB = new UserDBHelper(context);
        userDB.insert(new Food("매생이 국","www.weara.com","www.image.com","물건","30분","어려움",0,10));
        Food f=userDB.getFoodbyID(0);
        System.out.println("그냥"+f.getName()+f.getDetailUrl());
        if(userDB.delete(f)!=1)
            System.out.println("안지워짐!"+f.getName()+f.getDetailUrl());
        f=userDB.getFoodbyID(0);
        if(f!=null)System.out.println("왜안지워져"+f.getName()+f.getDetailUrl());

    }
}
