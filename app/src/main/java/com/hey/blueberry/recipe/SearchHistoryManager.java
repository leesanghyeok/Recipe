package com.hey.blueberry.recipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m2j97 on 2018-04-13.
 */

public class SearchHistoryManager {

    private SharedPreferences sharedPreferences;

    public SearchHistoryManager(Context applicationContext){

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public List<String> getItems() {
        List<String> dataList = new ArrayList<>();

        for(int i = 0; i < getSize(); i++)
        {
            dataList.add(sharedPreferences.getString("Status_" + i, null));
        }

        return dataList;
    }

    private void add(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    private void add(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private int getSize() {
        return sharedPreferences.getInt("Status_size", 0);
    }
    private void increaseSize()  {
        int size = getSize();
        size += 1;
        add("Status_size", size);
    }

    private void decreaseSize()  {
        int size = getSize();
        size -= 1;
        add("Status_size", size);
    }

    public void addItem(int position, String name) {
        add("Status_" + position, name);
        increaseSize();
    }

    public void removeItem(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int index, dataSize = getSize();
        String str;
        List<String> datas = getItems();

        for (index = 0; index < dataSize; index++) {
            str = sharedPreferences.getString("Status_" + index, null);
            datas.add(str);
            if (name.equals(str))
                break;
        }

        if (index != dataSize) {
            datas.remove(index);
            editor.clear();
            decreaseSize();
            dataSize--;

            for(int i = 0; i < dataSize; i++)
            {
                editor.putString("Status_" + i, datas.get(i));
            }
        }

        editor.putInt("Status_size", dataSize);
        editor.commit();
    }
}
