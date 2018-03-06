package com.hey.blueberry.recipe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.hey.blueberry.recipe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daeyo on 2018-02-20.
 */

public class RecipeActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView1, mRecyclerView2;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Intent intent = getIntent();
        String data = intent.getStringExtra("from");
        TextView tx = (TextView)findViewById(R.id.wherefrom);
        tx.setText(data);

        mRecyclerView1 = (RecyclerView) findViewById(R.id.recipe_view);
        mRecyclerView2 = (RecyclerView) findViewById(R.id.recipeStep_view);
        mRecyclerView1.setHasFixedSize(true);
        mRecyclerView2.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView2.setLayoutManager(mLayoutManager);


        List<RecipeStep_item> items = new ArrayList<>();
        RecipeStep_item[] item = new RecipeStep_item[5];
        item[0]=new RecipeStep_item(R.drawable.a,"1. 뭘뭘한다");
        item[1]=new RecipeStep_item(R.drawable.b,"2. 삶는다");
        item[2]=new RecipeStep_item(R.drawable.c,"3. 볶는다");
        item[3]=new RecipeStep_item(R.drawable.d,"4. 갈비찜을 밥 위에 얹어주세요~ 갈비찜을 밥이랑 비벼주세요~ 내가 제일 좋아하는 갈비찜 덮밥");
        item[4]=new RecipeStep_item(R.drawable.e,"5. 냠냠!");

        for(int i =0; i<5; i++)
            items.add(item[i]);

        mAdapter = new RecipeStepAdapter(getApplicationContext(),items,R.layout.activity_main);
        mRecyclerView2.setAdapter(mAdapter);
    }
}
