package com.hey.blueberry.recipe;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sangeun on 2018-03-25. */

public class DBHelper extends SQLiteAssetHelper {


    private static final String DB_NAME = "food.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 2);
        this.myContext = context;
        setForcedUpgrade();
    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    public List<Food> search(List<String> content) {
        myDataBase = getReadableDatabase();
        List<Food> result = new ArrayList<>();
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        if("".equals(content.get(0)))return result;
        else {
            String selection = "Material LIKE ?";
            String[] where=new String[content.size()];
            where[0] = "%" + content.get(0) + "%";
            for(int i=1;i<content.size();i++) {
                selection+="AND Material LIKE ?";
                where[i]="%" + content.get(0) + "%";
            }
            Cursor cursor = myDataBase.query("FOOD", null, selection,
                    where,
                    null, null, null, null);
            while (cursor.moveToNext()) {
                Food food = new Food(cursor.getString(cursor.getColumnIndex("NAME")), "http://board.miznet.daum.net/gaia/do/cook/recipe/mizr/"+cursor.getString(cursor.getColumnIndex("DETAILURL")), cursor.getString(cursor.getColumnIndex("IMAGE")).trim() , cursor.getString(cursor.getColumnIndex("MATERIAL")), cursor.getString(cursor.getColumnIndex("TIME")), cursor.getString(cursor.getColumnIndex("DIFFICULTY")));
                result.add(food);
            }
            return result;
        }
    }
}

