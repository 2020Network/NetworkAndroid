package com.example.studygorup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FileFragment extends Fragment {
    private RecyclerView recyclerView;
    private FileAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file, container, false);

        recyclerView = view.findViewById(R.id.recycler);

        list = createNoticeList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new FileAdapter(getActivity(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Log.d("TAG", "Notice Fragment");

        return view;
    }

    private ArrayList<String> createNoticeList(int num) {
        ArrayList<String> contacts = new ArrayList<String>();

        for(int i =1; i<= num; i++){
            contacts.add("2020년 "+i+"월 모평 지문");
        }

        return contacts;
    }
}