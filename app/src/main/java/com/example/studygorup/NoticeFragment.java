package com.example.studygorup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.Toast;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {

    private RecyclerView recyclerView;
    private NoticeAdapter adapter;
    private ArrayList<NoticeItemData> list = new ArrayList<>();

    ImageView addBtn;
    Button btnClose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        /*btnClose = view.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlidingDrawer drawer = view.findViewById(R.id.sliding_drawer);
                drawer.animateClose();
            }
        });*/

        /*addBtn = view.findViewById(R.id.noticeAddBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(container.getContext(), "공지를 추가하자", Toast.LENGTH_SHORT).show();
            }
        });*/

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