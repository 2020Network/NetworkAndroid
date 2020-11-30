package com.example.studygorup;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studygorup.DTO.Login;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {

    private RecyclerView recyclerView;
    private NoticeAdapter adapter;
    private ArrayList<NoticeItemData> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        recyclerView = view.findViewById(R.id.recycler);

        list = NoticeItemData.createNoticeList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new NoticeAdapter(getActivity(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        Log.d("TAG", "Notice Fragment");

       return view;
    }

}