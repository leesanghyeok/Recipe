package com.hey.blueberry.recipe;

/**
 * Created by m2j97 on 2018-03-11.
 */

public class SearchListViewItem {
    private String name;

    /**
     * 리스트뷰 아이템에 출력할 텍스트 정보를 저장하는 메소드
     * @param inputName 저장할 텍스트 정보
     */
    public void setName(String inputName)
    {
        this.name = inputName;
    }

    /**
     * 리스트뷰 아이템의 텍스트 정보를 출력하는 메소드
     * @return 리스트뷰 아이템의 텍스트 정보
     */
    public String getName()
    {
        return this.name;
    }
}
