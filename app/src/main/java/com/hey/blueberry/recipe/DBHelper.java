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
        myDataBase = getReadableDatabase();
    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return myDataBase.query(....)" so it'd be easy
    // to you to create adapters for your views.

    public List<Food> search(List<String> content) {
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
                Food tmp = new Food(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                result.add(tmp);
                System.out.println(tmp.getName() + "\n" + tmp.getDetailUrl() + "\n" + tmp.getImage() + "\n" + tmp.getMaterial() + "\n" + tmp.getTime() + "\n" + tmp.getDifficulty());
            }
            return result;
        }
    }
}

