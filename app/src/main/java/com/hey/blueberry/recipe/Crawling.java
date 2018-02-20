package com.hey.blueberry.recipe;

/**
 * Created by sangeun on 2018-02-19.
 */


import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Crawling {
    private String htmlPageUrl="http://cook.miznet.daum.net/search/search.do?t=recipe&q=";
    List<Food> food = new ArrayList<Food>();
    private ImageView imageScreen;
    private TextView explain;
    private String find;

    public Crawling(String find){
        this.find=find;
    }

    class JsoupAsynTask extends AsyncTask<Void, Void, Void> {

        //@Override
        protected  void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected  Void doInBackground(Void... params){
            try{
                find=find.replaceAll(" ","+");
                htmlPageUrl+=find;
                Document doc=Jsoup.connect(htmlPageUrl).get();
                Elements links=doc.select(".tit > a");

                for(int i=0;i<links.size();i++){
                    food.add(new Food());
                    food.get(i).name=links.get(i).text().trim();
                    food.get(i).image=doc.select("#searchArea .uccUl #recipe_img_"+(i+1)+" > img").attr("src");
                    System.out.println(food.get(i).name);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
        }
    }

}
