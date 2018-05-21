package com.hey.blueberry.recipe;


import android.graphics.Color;
import android.support.v7.widget.SearchView;

import java.io.IOException;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

class MainActivity extends AppCompatActivity {

    private static final String TABLE_NAME = "bookmarks";
    String[] moreNameArray = new String[]{
            "가재", "고사리", "곤약", "도라지", "도루묵", "도토리묵", "들깨", "어묵", "청포묵", "토란", "톳"
    };
    List<ToggleButton> nameBtnArray = new ArrayList<>();   // 화면 내 모든 재료명 버튼들
    List<Button> addedBtnArray = new ArrayList<>();     // 선택되어 하단에 추가된 재료명 버튼



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바의 뒤로가기를 활성화하여 즐겨찾기 버튼 아이콘으로 수정
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);

        if(this.getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_star_border_white_24dp);
        }

        //어댑터를 만들고 자동완성 스트링 리스트와 연결해줌
        ArrayAdapter<String> adWord = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, moreNameArray);
        AutoCompleteTextView autoEdit = (AutoCompleteTextView) findViewById(R.id.autoEdit);
        autoEdit.setAdapter(adWord);


        DBexample dbu = new DBexample(getApplicationContext());
        dbu.example();

        //식재료 버튼 리스너 및 배열 추가
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn1));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn2));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn3));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn4));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn5));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn6));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn7));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn8));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn9));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn10));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn11));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn12));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn13));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn14));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn15));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn16));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn17));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn18));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn19));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn20));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn21));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn22));
        nameBtnArray.add((ToggleButton) findViewById(R.id.nameBtn23));

        for(int i = 0; i < 23; i++) {
            nameBtnArray.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToggleButton tb = (ToggleButton) v;
                    if (tb.isChecked()) {
                        addNewBtn(((ToggleButton) v).getText().toString());
                    }
                    else {
                        removeBtn(((ToggleButton) v).getText().toString());
                    }
                }
            });
        }

        //추가 버튼
        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AutoCompleteTextView autoEdit = (AutoCompleteTextView) findViewById(R.id.autoEdit);
                addNewBtn(autoEdit.getText().toString());
                autoEdit.setText("");

                //키보드 숨기기
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(autoEdit.getWindowToken(), 0);
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
            case R.id.action_search: {
                Toast.makeText(this, "검색 버튼 누름", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,SearchActivity.class);
                startActivity(intent);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 해당 파라미터의 값을 text로 가진 버튼 생성하는 함수
     *
     * @param name 생성할 버튼의 text 값
     */

    void addNewBtn(String name) {
        //추가되지 않은 새로운 음식재료일 경우 버튼 생성 및 추가
        if (isNew(name)) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.added_btn_layout);
            Button newBtn = new Button(this);
            newBtn.setText(name);
            newBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeBtn(((Button) v).getText().toString());
                }
            });
            addedBtnArray.add(newBtn);
            layout.addView(newBtn);

            //음식재료명 버튼이 off 상태일 경우 -> on
            for (int i = 0; i < nameBtnArray.size(); i++)
                if (name.equals(nameBtnArray.get(i).getText().toString())) {
                    nameBtnArray.get(i).setChecked(true);
                    break;
                }
        }
    }

    /**
     * 선택한 음식재료 버튼을 삭제하는 함수
     *
     * @param name 삭제하기 위해 선택한 음식재료명
     */
    void removeBtn(String name) {
        //해당 이름의 음식 재료 선택 해제
        Toast.makeText(MainActivity.this, name + " 삭제", Toast.LENGTH_SHORT).show();
        LinearLayout layout = (LinearLayout) findViewById(R.id.added_btn_layout);
        for (int i = 0; i < addedBtnArray.size(); i++) {
            if (name.equals(addedBtnArray.get(i).getText().toString())) {
                layout.removeView(addedBtnArray.get(i));
                addedBtnArray.remove(i);
                break;
            }
        }

        //음식재료명 버튼이 on 상태일 경우 -> off
        for (int i = 0; i < nameBtnArray.size(); i++)
            if (name.equals(nameBtnArray.get(i).getText().toString())) {
                nameBtnArray.get(i).setChecked(false);
                break;
            }
    }


    /**
     * 해당 이름의 재료가 이미 선택되어있지 않은 새로운 재료인지 확인하는 메소드
     *
     * @param name 선택 여부 확인할 이름
     * @return 새로 선택된 것인지에 대한 여부
     */
    boolean isNew(String name) {
        for (int i = 0; i < addedBtnArray.size(); i++)
            if (name.equals(addedBtnArray.get(i).getText().toString())) {
                Toast.makeText(this, "이미 추가된 재료입니다.", Toast.LENGTH_SHORT).show();
                return false;
            }
        return true;
    }
}
