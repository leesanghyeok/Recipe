package com.hey.blueberry.recipe;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


        import java.util.ArrayList;
        import java.util.List;
/**
 * Created by sangeun on 2018-05-07.
 */

public class UserDBHelper extends SQLiteAssetHelper{
    private static final String DB_NAME = "user.db";

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public UserDBHelper(Context context) {
        super(context, DB_NAME, null, 2);
        this.myContext = context;
        setForcedUpgrade();
    }
    public Food insert(Food f) {
        myDataBase = getWritableDatabase();
        String sqlInsert = "INSERT INTO FOOD" + "(NAME, DETAILURL, IMAGE, MATERIAL, TIME, DIFFICULTY) VALUES (" +"'"+ f.getName() +"'"+ "," + "'" + f.getDetailUrl() + "'," + "'" + f.getImage() + "'," +"'" + f.getMaterial() + "',"+"'" + f.getTime() + "',"+"'" + f.getDifficulty() + "'"+")";
        myDataBase.execSQL(sqlInsert);
        myDataBase.close();
        return f;
    }

    public int delete(int id){
        myDataBase = getWritableDatabase();
        /*String sqldelete = "DELETE FROM FOOD WHERE ID="+id;
        myDataBase.execSQL(sqldelete);*/
        return myDataBase.delete("FOOD","ID = "+id,null);
        //myDataBase.close();
    }

    public int delete(Food f){
        myDataBase = getWritableDatabase();
        int res = myDataBase.delete("FOOD","NAME = "+"'"+f.getName()+"'",null);
        return res;
    }


    public Food getFoodbyID(int id){
        myDataBase = getReadableDatabase();
        Cursor cursor = myDataBase.rawQuery("SELECT * FROM FOOD",null);
        if(cursor.getCount()>0) {
            cursor.moveToNext();
            Food food = new Food(cursor.getString(cursor.getColumnIndex("NAME")), "http://board.miznet.daum.net/gaia/do/cook/recipe/mizr/" + cursor.getString(cursor.getColumnIndex("DETAILURL")), cursor.getString(cursor.getColumnIndex("IMAGE")).trim(), cursor.getString(cursor.getColumnIndex("MATERIAL")), cursor.getString(cursor.getColumnIndex("TIME")), cursor.getString(cursor.getColumnIndex("DIFFICULTY")));

            return food;
        }
        else return null;
    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }
}
