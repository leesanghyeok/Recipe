package com.hey.blueberry.recipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

/**
 * Created by m2j97 on 2018-02-27.
 */

public class SearchActivity extends AppCompatActivity {

    private ListView listView;
    private SearchListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        adapter = new SearchListViewAdapter();
        loadArray(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.searchToolbar);

        this.setSupportActionBar(toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayShowHomeEnabled(true);
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.getSupportActionBar().setTitle("");
        }

        //서치뷰 글씨 색상 설정
        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setHintTextColor(Color.GRAY);

        //리스트뷰 아이템 동적 원소 추가
        listView = (ListView) findViewById(R.id.historyListView);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                //검색 시 동작할 코드

                //기존에 검색한 기록이 있을 경우 삭제
                if(adapter.isExisted(s))
                        adapter.removeItem(s);

                //최근 검색어를 맨 뒤에 추가함
                adapter.addItem(0, s);
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
    protected void onDestroy() {
        saveArray();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    /**
     * 툴바 메뉴 버튼의 각 동작코드를 담은 메소드
     *
     * @param item 클릭된 메뉴아이템
     * @return 동작 여부
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home: {
                // 해당 버튼을 눌렀을 때 적절한 액션을 넣는다.
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean saveArray()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEdit1 = sp.edit();
    /* sKey is an array */
        mEdit1.putInt("Status_size", adapter.getCount());

        for(int i=0;i<adapter.getCount();i++)
        {
            mEdit1.remove("Status_" + i);
            mEdit1.putString("Status_" + i, adapter.getItem(i));
        }

        return mEdit1.commit();
    }

    public void loadArray(Context mContext) {
        SharedPreferences mSharedPreference1 = PreferenceManager.getDefaultSharedPreferences(mContext);
        adapter.clear();
        int size = mSharedPreference1.getInt("Status_size", 0);

        for (int i = 0; i < size; i++) {
            adapter.addItem(i, mSharedPreference1.getString("Status_" + i, null));
        }
    }
}
