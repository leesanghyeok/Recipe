package com.hey.blueberry.recipe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hey.blueberry.recipe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daeyo on 2018-02-20.
 */

public class SearchListActivity extends AppCompatActivity {


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_searchlist);

            ListView listview = (ListView) findViewById(R.id.Slistview);


            List<String> list = new ArrayList<>();

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, list);

            listview.setAdapter(adapter);


            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView,
                                        View view, int position, long id) {

                    String selected_item = (String) adapterView.getItemAtPosition(position);
                    Intent intent = new Intent(SearchListActivity.this, RecipeActivity.class);
                    intent.putExtra("from","검색액티비티에서 건너 옴,"+selected_item+"의 레시피");
                    startActivity(intent);


                }
            });


            //리스트뷰에 보여질 임시 아이템
            list.add("갈비찜1");
            list.add("갈비찜2");
            list.add("갈비찜3");
            list.add("갈비찜4");

        }
    }
