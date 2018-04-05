package com.hey.blueberry.recipe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    protected static final String DATABASE_NAME = "databases/food.db";
    protected static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "bookmarks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바의 뒤로가기를 활성화하여 즐겨찾기 버튼 아이콘으로 수정
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_star_border_white_24dp);

        DBHelper DB=new DBHelper(getApplicationContext());
        String[] s=new String[]{"매생이","굴"};
        System.out.println(s);
        DB.search(s);


        //서치뷰 글씨 색상 설정
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setHintTextColor(Color.GRAY);
        searchAutoComplete.setTextColor(Color.WHITE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                //검색 시 동작할 코드
                Toast.makeText(MainActivity.this, "검색", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //입력 중 동작할 코드
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                // 즐겨찾기 버튼을 눌렀을 때 적절한 액션을 넣는다.
                Toast.makeText(this, "즐겨찾기 버튼 누름", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
