package com.hey.blueberry.recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m2j97 on 2018-03-11.
 */

public class SearchListViewAdapter extends BaseAdapter{

    private List<SearchListViewItem> listViewItemList = new ArrayList<>();

    public SearchListViewAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_search, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView nameTextView = (TextView) convertView.findViewById(R.id.list_item_text) ;
        Button cancelBtn = (Button) convertView.findViewById(R.id.list_item_btn);

        // 클릭 리스너 등록
        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewItemList.remove(pos);
                SearchListViewItem item = new SearchListViewItem();
                item.setName(((TextView)v).getText().toString());
                listViewItemList.add(0, item);
                notifyDataSetChanged();
            }
        });

        cancelBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewItemList.remove(pos);
                notifyDataSetChanged();
            }
        });

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        SearchListViewItem listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        nameTextView.setText(listViewItem.getName());

        return convertView;
    }

    public void addItem(String name) {
        SearchListViewItem item = new SearchListViewItem();

        item.setName(name);
        listViewItemList.add(item);
    }

    public void addItem(int position, String name) {
        SearchListViewItem item = new SearchListViewItem();

        item.setName(name);
        listViewItemList.add(position, item);
    }

    public void removeItem(String s) {
        for(int  i = 0; i < listViewItemList.size(); i++)
            if(s.equals(listViewItemList.get(i).getName()))
                listViewItemList.remove(i);
    }

    public boolean isExisted(String s) {
        for(int  i = 0; i < listViewItemList.size(); i++)
            if(s.equals(listViewItemList.get(i).getName()))
                return true;

        return false;
    }
}
