package com.hey.blueberry.recipe.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hey.blueberry.recipe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daeyo on 2018-02-20.
 */

public class FavoritesListActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriteslist);

        RecyclerView mRecyclerView1;
        RecyclerView.Adapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;

        mRecyclerView1 = (RecyclerView) findViewById(R.id.favoritesList_view);
        mRecyclerView1.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView1.setLayoutManager(mLayoutManager);


        List<RecipeItem> items = new ArrayList<>();

        items.add(new RecipeItem("명절 음식 활용, 우주선 볶음밥","요리재료 ▶ 재료 : 밥 1공기, 모둠전(산적 1개, 쇠고기 전 2개, 동그랑땡 3개, 연근전 2개), 호박 1/3개, 당근 1/3개, 계란 3개, 대파, 햄프씨드, 김가루, 소금, 콩기름, 깨소금, 참기름 약간 - 명절음식 활용법 , 모둠전 , 우주선볶음밥", "45분 이내","초보", "http://t1.daumcdn.net/thumb/C115x85/?fname=http%3A%2F%2Fm1.daumcdn.net%2Fcfile165%2Fattach%2F9957A7415A8DBAA21842A4", "read?articleId=77388&bbsId=MC001&pageIndex=1", true));
        items.add(new RecipeItem("명절 음식 활용, 우주선 볶음밥","요리재료 ▶ 재료 : 밥 1공기, 모둠전(산적 1개, 쇠고기 전 2개, 동그랑땡 3개, 연근전 2개), 호박 1/3개, 당근 1/3개, 계란 3개, 대파, 햄프씨드, 김가루, 소금, 콩기름, 깨소금, 참기름 약간 - 명절음식 활용법 , 모둠전 , 우주선볶음밥", "45분 이내","초보", "http://t1.daumcdn.net/thumb/C115x85/?fname=http%3A%2F%2Fm1.daumcdn.net%2Fcfile165%2Fattach%2F9957A7415A8DBAA21842A4", "read?articleId=77388&bbsId=MC001&pageIndex=1", true));
        items.add(new RecipeItem("담백학고 깔끔한 맛의 '닭백숙 만들기'", "요리재료 닭 500g 한마리, 무 2조각, 통후추 1/4T, 마늘 7개, 대추 7개, 황기 조금, 대파 1뿌리, (기호에 따라) 소금간 - 닭백숙 , 닭백숙 만들기 , 레시피 , 요리 , 푸드", "1시간 이내", "보통", "http://t1.daumcdn.net/thumb/C115x85/?fname=http%3A%2F%2Fm1.daumcdn.net%2Fcfile162%2Fattach%2F99E5E03C5A8D3C6709CAF7", "\n" +
                "read?articleId=77387&bbsId=MC001&pageIndex=1", true));

        items.add(new RecipeItem("마늘향이 폴폴 나는 촉촉한 프렌치토스트", "요리재료 우유1/2컵, 계란 1개,통식빵 1/2개식용유 1큰술, 버터 1큰술, 다진마늘 1큰술, 설탕 1큰술 - -", "15분 이내", "초보", "http://t1.daumcdn.net/thumb/C115x85/?fname=http%3A%2F%2Fm1.daumcdn.net%2Fcfile163%2Fattach%2F992C28415A8CE08301DC9D", "read?articleId=77386&bbsId=MC001&pageIndex=1", true));
        items.add(new RecipeItem("[오소리감투 볶음] 오소리감투 볶음 만드는 법", "요리재료 오소리감투 외 - 돼지부속물 , 레시피 , 만드는법 , 만들기 , 반찬 , 볶음 , 오소리감투 , 오소리감투볶음 , 요리", "15분 이내", "보통", "http://t1.daumcdn.net/thumb/C115x85/?fname=http%3A%2F%2Fm1.daumcdn.net%2Fcfile163%2Fattach%2F99BFA6365A8CB04B2F4C0E", "read?articleId=77384&bbsId=MC001&pageIndex=1", true));
        items.add(new RecipeItem("통통한 황태살에 빨간옷을 입혀~ 고추장황태구이", "요리재료 황태4마리,마늘6알,생강1쪽,배,양파1/2개씩,검은깨,통깨 약간씩.* 양념: 마늘,생강,양파,배 간것1컵,고추장3숟갈,간장5숟갈,포도씨유,참기름3숟갈씩,올리고당3숟갈,설탕청주2숟갈씩,후춧가루,깨소금 약간씩. - 어린이요리교실", "1시간이내", "보통", " http://t1.daumcdn.net/thumb/C115x85/?fname=http%3A%2F%2Fm1.daumcdn.net%2Fcfile65%2Fattach%2F996B8B4F5A8CC68B231639", "read?articleId=77385&bbsId=MC001&pageIndex=1", true));

        mAdapter = new RecipeAdapter(getApplicationContext(),items);
        mRecyclerView1.setAdapter(mAdapter);

    }
}
