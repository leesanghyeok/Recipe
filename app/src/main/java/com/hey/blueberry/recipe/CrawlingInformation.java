package com.hey.blueberry.recipe;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.ceil;

/**
 * Created by sangeun on 2018-03-25.
 */

public class CrawlingInformation {
    List<Food> food = new ArrayList<Food>();
    String htmlPageUrl = "http://cook.miznet.daum.net/search/search.do?t=recipe&q=";

    private class JsoupAsynTask extends AsyncTask<Void, Void, Void> {

        //@Override
        protected  void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params){
            System.out.println(htmlPageUrl);

            Document num = null;    //몇개가 검색되는지
            try {
                num = Jsoup.connect(htmlPageUrl).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements a = num.select(".body_center span.num");
            String Stotal=a.get(0).text();
            int s=Stotal.indexOf("총");
            int l=Stotal.indexOf("건");
            Stotal=Stotal.substring(s+2,l);
            System.out.println(Stotal);
            int total=Integer.parseInt(Stotal);

            for(int j=1;j<=ceil((double)total/10);j++) {
                Document doc = null;
                try {
                    doc = Jsoup.connect(htmlPageUrl+"&pageNo="+j).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements title;
                title = doc.select(".tit > a");
                Elements img;
                img = doc.select("[height=85]");
                System.out.println(title.size());
                for (int i = 0; i < title.size(); i++) {
                    System.out.println(i+"+"+j);
                    System.out.println(title.get(i).text());

                    Document raw = null;
                    try {
                        raw = Jsoup.connect("http://board.miznet.daum.net/gaia/do/cook/recipe/mizr/" + title.get(i).attr("href")).get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(raw.select(".recipe_details .stuff").text());
                    System.out.println(title.get(i).attr("href"));
                    System.out.println(raw.select("#selector_time").text());
                    System.out.println( raw.select("#selector_difficulty").text());
                    System.out.println(img.get(i).attr("src"));
                    Food tmp = new Food(raw.select(".recipe_details .stuff").text(), title.get(i).text(), img.get(i).attr("src"), title.get(i).attr("href"), raw.select("#selector_time").text(), raw.select("#selector_difficulty").text());
                    food.add(tmp);
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
        }
    }

    public void CallAsynTask(String content) {
        content = content.replace(" ", "+");
        htmlPageUrl += content;
        JsoupAsynTask j=new JsoupAsynTask();
        j.execute();
    }
}
