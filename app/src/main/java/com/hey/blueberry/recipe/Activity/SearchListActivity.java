package com.hey.blueberry.recipe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hey.blueberry.recipe.DBHelper;
import com.hey.blueberry.recipe.Food;
import com.hey.blueberry.recipe.R;

import java.util.List;

/**
 * Created by daeyo on 2018-05-21.
 */

public class SearchListActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchlist);

        Intent intent = getIntent();
        List<String> nameList;
        DBHelper dbHelper = new DBHelper(this);

        nameList = intent.getStringArrayListExtra("nameList");

        RecyclerView mRecyclerView1;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        mRecyclerView1 = (RecyclerView) findViewById(R.id.searchList_view);
        mRecyclerView1.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView1.setLayoutManager(mLayoutManager);


        List<Food> items = dbHelper.search(nameList);

        mAdapter = new RecipeAdapter(getApplicationContext(),items);
        mRecyclerView1.setAdapter(mAdapter);

    }
}
