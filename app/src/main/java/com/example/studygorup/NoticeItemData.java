package com.example.studygorup;

import android.os.Debug;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NoticeItemData {
    public String title;
    public String contents;

    public NoticeItemData(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static ArrayList<NoticeItemData> createNoticeList(int numContacts){
        ArrayList<NoticeItemData> contacts = new ArrayList<NoticeItemData>();

        for(int i =1; i<= numContacts; i++){
            contacts.add(new NoticeItemData("제목","내용"));
            Log.d("TAG", "listNum: "+ i);
        }

        Log.d("TAG","createNoticeList");

        return contacts;
    }
}
