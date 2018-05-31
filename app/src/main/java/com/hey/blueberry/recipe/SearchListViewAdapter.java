package com.hey.blueberry.recipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hey.blueberry.recipe.Activity.SearchListActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m2j97 on 2018-03-11.
 */

public class SearchListViewAdapter extends BaseAdapter {

    private List<String> listViewItemList = new ArrayList<>();
    private SearchHistoryManager searchHistoryManager;
    private Context context;
    public void setDataManager(SearchHistoryManager manager) {
        this.searchHistoryManager = manager;
    }

    /**
     * 리스트뷰 아이템의 리스트 크기를 출력하는 메소드
     *
     * @return 리스트뷰 아이템 리스트의 크기
     */
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    /**
     * 리스트뷰 아이템의 리스트에서 해당 위치의 리스트뷰 아이템을 가져오는 메소드
     *
     * @param position 리스트뷰 아이템 리스트에서 가져올 아이템의 위치
     * @return 리스트뷰 아이템
     */
    @Override
    public String getItem(int position) {
        return listViewItemList.get(position);
    }

    /**
     * 아이템의 리스트 상의 위치를 출력하는 메소드
     *
     * @param position 아이템의 리스트 상의 위치
     * @return 아이템의 리스트 상의 위치
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item_search, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView nameTextView = (TextView) convertView.findViewById(R.id.list_item_text);
        Button cancelBtn = (Button) convertView.findViewById(R.id.list_item_btn);

        // 클릭 리스너 등록
        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = ((TextView) v).getText().toString();
                removeItem(item);
                addItem(0, item);
                notifyDataSetChanged();
            }
        });

        cancelBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                notifyDataSetChanged();
            }
        });

        // 아이템 내 위젯에 데이터 반영
        nameTextView.setText(listViewItemList.get(position));

        return convertView;
    }

    /**
     * 리스트뷰 아이템 리스트에 해당 위치에 아이템을 추가하는 메소드
     *
     * @param position 추가할 위치
     * @param name     추가할 아이템이 가질 텍스트 정보
     */
    public void addItem(int position, String name) {
        searchHistoryManager.addItem(listViewItemList.size(), name);
        listViewItemList.add(position, name);

        //검색 시 해당 검색 제품의 SearchListActivity로 이동
        Toast.makeText(context, name+" 검색", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SearchListActivity.class);
        intent.putExtra("schname", name);
        context.startActivity(intent);
    }

    /**
     * 리스트뷰 아이템 리스트에서 해당 텍스트 정보를 가진 아이템을 삭제하는 메소드
     *
     * @param s 삭제할 아이템의 텍스트 정보
     */
    public void removeItem(String s) {
        for (int i = 0; i < listViewItemList.size(); i++) {
            if (s.equals(listViewItemList.get(i))) {
                searchHistoryManager.removeItem(s);
                listViewItemList.remove(i);
            }
        }
    }

    public void removeItem(int position) {
        searchHistoryManager.removeItem(listViewItemList.get(position));
        listViewItemList.remove(position);
    }

    /**
     * 리스트뷰 아이템 리스트 상에 해당 텍스트 정보를 가진 아이템이 존재하는지 확인하는 메소드
     *
     * @param s 확인할 텍스트 정보
     * @return 리스트 상의 존재 여부
     */
    public boolean isExisted(String s) {
        return listViewItemList.contains(s);
    }

    public void setItems(List<String> dataList) {

        for (int i = 0; i < dataList.size(); i++) {
            listViewItemList.add(0, dataList.get(i));
        }
    }
}
