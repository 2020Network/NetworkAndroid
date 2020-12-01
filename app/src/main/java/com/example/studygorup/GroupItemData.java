package com.example.studygorup;

import android.util.Log;

import java.util.ArrayList;

public class GroupItemData {
    public String title;
    public String contents;

    public GroupItemData(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static ArrayList<GroupItemData> createGroupList(int numContacts){
        ArrayList<GroupItemData> contacts = new ArrayList<GroupItemData>();

        for(int i =1; i<= numContacts; i++){
            contacts.add(new GroupItemData("제목","내용"));
            Log.d("TAG", "listNum: "+ i);
        }

        Log.d("TAG","createGroupList");

        return contacts;
    }
}
