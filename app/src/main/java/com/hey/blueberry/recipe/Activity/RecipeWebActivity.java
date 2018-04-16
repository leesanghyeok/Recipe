package com.hey.blueberry.recipe.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hey.blueberry.recipe.R;

/**
 * Created by daeyo on 2018-04-14.
 */

public class RecipeWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //주소 데이터 받아오기
        Intent intent = getIntent();
        String url;

        url = intent.getStringExtra("url");
        WebView recipeWeb = (WebView)findViewById(R.id.recipe_web);

        //웹뷰 설정
        WebSettings webSettings = recipeWeb.getSettings();
        webSettings.setJavaScriptEnabled(true); //자바스크립트 동작 여부
        webSettings.setSupportZoom(true); //손가락으로 줌 사용할지 여부
        webSettings.setBuiltInZoomControls(true); //내부 줌 사용 여부

        //웹뷰 실행
        recipeWeb.loadUrl(url);
    }
}
