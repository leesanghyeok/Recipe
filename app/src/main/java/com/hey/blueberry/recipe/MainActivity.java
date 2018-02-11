package com.hey.blueberry.recipe;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    String [] moreNameArray = new String[]{
            "가재", "고사리", "곤약", "도라지", "도루묵", "도토리묵", "들깨", "어묵", "청포묵", "토란", "톳"
    };
    ArrayList<ToggleButton> nameBtnArray = new ArrayList<>();
    ArrayList<Button> addedBtnArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바의 뒤로가기를 활성화하여 즐겨찾기 버튼 아이콘으로 수정
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_star_border_white_24dp);

        //서치뷰 글씨 색상 설정
        SearchView searchView = (SearchView) findViewById(R.id.search_view);
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setHintTextColor(Color.GRAY);
        searchAutoComplete.setTextColor(Color.WHITE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {

            @Override
            public boolean onQueryTextSubmit(String s)
            {
                //검색 시 동작할 코드
                Toast.makeText(MainActivity.this, "검색", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                //입력 중 동작할 코드
                return false;
            }
        });

        //어댑터를 만들고 자동완성 스트링 리스트와 연결해줌
        ArrayAdapter<String> adWord = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, moreNameArray);
        AutoCompleteTextView autoEdit = (AutoCompleteTextView)findViewById(R.id.autoEdit);
        autoEdit.setAdapter(adWord);

        //식재료 버튼 리스너 및 배열 추가
        ToggleButton eggBtn = (ToggleButton) findViewById(R.id.eggBtn);
        ToggleButton chickenBtn = (ToggleButton)findViewById(R.id.chickenBtn);
        ToggleButton porkBtn = (ToggleButton) findViewById(R.id.porkBtn);
        ToggleButton beefBtn = (ToggleButton) findViewById(R.id.beefBtn);
        ToggleButton duckBtn = (ToggleButton) findViewById(R.id.duckBtn);
        ToggleButton lambBtn = (ToggleButton) findViewById(R.id.lambBtn);
        ToggleButton fishBtn = (ToggleButton) findViewById(R.id.fishBtn);
        ToggleButton squidBtn = (ToggleButton) findViewById(R.id.squidBtn);
        ToggleButton shrimpBtn = (ToggleButton) findViewById(R.id.shrimpBtn);
        ToggleButton crabBtn = (ToggleButton) findViewById(R.id.crabBtn);
        ToggleButton shellBtn = (ToggleButton) findViewById(R.id.shellBtn);
        ToggleButton seaweedBtn = (ToggleButton) findViewById(R.id.seaweedBtn);
        ToggleButton onionBtn = (ToggleButton) findViewById(R.id.onionBtn);
        ToggleButton welshonBtn = (ToggleButton) findViewById(R.id.welshonBtn);
        ToggleButton garlicBtn = (ToggleButton) findViewById(R.id.garlicBtn);
        ToggleButton pimentBtn = (ToggleButton) findViewById(R.id.pimentBtn);
        ToggleButton paprikaBtn = (ToggleButton) findViewById(R.id.paprikaBtn);
        ToggleButton cucumberBtn = (ToggleButton) findViewById(R.id.cucumberBtn);
        ToggleButton carrotBtn = (ToggleButton) findViewById(R.id.carrotBtn);
        ToggleButton potatoBtn = (ToggleButton) findViewById(R.id.potatoBtn);
        ToggleButton sweetpotBtn = (ToggleButton) findViewById(R.id.sweetpotBtn);
        ToggleButton eggplantBtn = (ToggleButton) findViewById(R.id.eggplantBtn);
        ToggleButton pumpkinBtn = (ToggleButton) findViewById(R.id.pumpkinBtn);

        eggBtn.setOnClickListener(this);
        chickenBtn.setOnClickListener(this);
        porkBtn.setOnClickListener(this);
        beefBtn.setOnClickListener(this);
        duckBtn.setOnClickListener(this);
        lambBtn.setOnClickListener(this);
        fishBtn.setOnClickListener(this);
        squidBtn.setOnClickListener(this);
        shrimpBtn.setOnClickListener(this);
        crabBtn.setOnClickListener(this);
        shellBtn.setOnClickListener(this);
        seaweedBtn.setOnClickListener(this);
        onionBtn.setOnClickListener(this);
        welshonBtn.setOnClickListener(this);
        garlicBtn.setOnClickListener(this);
        pimentBtn.setOnClickListener(this);
        paprikaBtn.setOnClickListener(this);
        cucumberBtn.setOnClickListener(this);
        carrotBtn.setOnClickListener(this);
        potatoBtn.setOnClickListener(this);
        sweetpotBtn.setOnClickListener(this);
        eggplantBtn.setOnClickListener(this);
        pumpkinBtn.setOnClickListener(this);

        nameBtnArray.add(eggBtn);
        nameBtnArray.add(chickenBtn);
        nameBtnArray.add(porkBtn);
        nameBtnArray.add(beefBtn);
        nameBtnArray.add(duckBtn);
        nameBtnArray.add(lambBtn);
        nameBtnArray.add(fishBtn);
        nameBtnArray.add(squidBtn);
        nameBtnArray.add(shrimpBtn);
        nameBtnArray.add(crabBtn);
        nameBtnArray.add(shellBtn);
        nameBtnArray.add(seaweedBtn);
        nameBtnArray.add(onionBtn);
        nameBtnArray.add(welshonBtn);
        nameBtnArray.add(garlicBtn);
        nameBtnArray.add(pimentBtn);
        nameBtnArray.add(paprikaBtn);
        nameBtnArray.add(cucumberBtn);
        nameBtnArray.add(carrotBtn);
        nameBtnArray.add(potatoBtn);
        nameBtnArray.add(sweetpotBtn);
        nameBtnArray.add(eggplantBtn);
        nameBtnArray.add(pumpkinBtn);

        //추가 버튼
        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
    }

    /**
     * 액션바 메뉴 버튼의 각 동작코드를 담은 함수
     * @param item 클릭된 메뉴아이템
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case android.R.id.home:
            {
                // 즐겨찾기 버튼을 눌렀을 때 적절한 액션을 넣는다.
                Toast.makeText(this, "즐겨찾기 버튼 누름", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 재료 토글버튼 클릭시 이벤트
     * @param v 클릭된 토글버튼
     */
    @Override
    public void onClick(View v)
    {
        if(v.getId() == R.id.addBtn)
        {
            AutoCompleteTextView autoEdit = (AutoCompleteTextView) findViewById(R.id.autoEdit);
            addNewBtn(autoEdit.getText().toString());
            autoEdit.setText("");

            //키보드 숨기기
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(autoEdit.getWindowToken(), 0);
        }
        else
        {
            ToggleButton tb = (ToggleButton) v;
            LinearLayout layout = (LinearLayout) findViewById(R.id.addedBtnLayout);
            if (tb.isChecked())
            {
                addNewBtn(((ToggleButton) v).getText().toString());
            }
            else
            {
                removeBtn(((ToggleButton) v).getText().toString());
            }
        }
    }

    /**
     * 해당 파라미터의 값을 text로 가진 버튼 생성하는 함수
     * @param name 생성할 버튼의 text 값
     */
    void addNewBtn(String name)
    {
        //기존에 추가된 재료인지 확인
        boolean isNew = true;
        for (int i = 0; i < addedBtnArray.size(); i++)
            if (name.compareTo(addedBtnArray.get(i).getText().toString()) == 0)
            {
                isNew = false;
                Toast.makeText(this, "이미 추가된 재료입니다.", Toast.LENGTH_SHORT).show();
                break;
            }

        //추가되지 않은 새로운 음식재료일 경우 버튼 생성 및 추가
        if (isNew)
        {
            LinearLayout layout = (LinearLayout) findViewById(R.id.addedBtnLayout);
            Button newBtn = new Button(this);
            newBtn.setText(name);
            newBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    removeBtn(((Button)v).getText().toString());
                }
            });
            addedBtnArray.add(newBtn);
            layout.addView(addedBtnArray.get(addedBtnArray.size() - 1));

            //음식재료명 버튼이 off 상태일 경우 -> on
            for(int i = 0; i < nameBtnArray.size(); i++)
                if(name.compareTo(nameBtnArray.get(i).getText().toString()) == 0)
                {
                    nameBtnArray.get(i).setChecked(true);
                    break;
                }
        }
    }

    /**
     * 선택한 음식재료 버튼을 삭제하는 함수
     * @param name 삭제하기 위해 선택한 음식재료명
     */
    void removeBtn(String name)
    {
        //해당 이름의 음식 재료 선택 해제
        Toast.makeText(MainActivity.this, name + " 삭제", Toast.LENGTH_SHORT).show();
        LinearLayout layout = (LinearLayout) findViewById(R.id.addedBtnLayout);
        for (int i = 0; i < addedBtnArray.size(); i++)
        {
            if (name.compareTo(addedBtnArray.get(i).getText().toString()) == 0)
            {
                layout.removeView(addedBtnArray.get(i));
                addedBtnArray.remove(i);
                break;
            }
        }

        //음식재료명 버튼이 on 상태일 경우 -> off
        for(int i = 0; i < nameBtnArray.size(); i++)
            if(name.compareTo(nameBtnArray.get(i).getText().toString()) == 0)
            {
                nameBtnArray.get(i).setChecked(false);
                break;
            }
    }
}
