package com.hey.blueberry.recipe;

/**
 * Created by sangeun on 2018-05-21.
 */

public class DBexample extends MainActivity {
    void example(){
        DBHelper db=new DBHelper(getApplicationContext());
        UserDBHelper userDB = new UserDBHelper(getApplicationContext());
        userDB.insert(new Food("매생이 국","www.weara.com","www.image.com","물건","30분","어려움"));
        Food f=userDB.getFoodbyID(0);
        System.out.println(f.getName()+f.getDetailUrl());
        if(userDB.delete(f)!=1)
            System.out.println(f.getName()+f.getDetailUrl());
        f=userDB.getFoodbyID(0);
        if(f!=null)System.out.println(f.getName()+f.getDetailUrl());

    }
}
