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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class FileFragment extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private FileAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();

    View view;

    TextView uploadBtn, postBtn, cancelBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_file, container, false);

        uploadBtn = view.findViewById(R.id.fileUpload);
        postBtn = view.findViewById(R.id.postBtn);
        cancelBtn = view.findViewById(R.id.cancelBtn);

        uploadBtn.setOnClickListener(this);
        postBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fileUpload:
                Toast.makeText(getContext(), "파일 등록하기", Toast.LENGTH_SHORT).show();
                break;
            case R.id.postBtn:
                SlidingDrawer drawer2 = view.findViewById(R.id.sliding_drawer);
                drawer2.animateClose();
                Toast.makeText(getContext(), "등록 되었습니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancelBtn:
                SlidingDrawer drawer = view.findViewById(R.id.sliding_drawer);
                drawer.animateClose();
                Toast.makeText(getContext(), "취소 되었습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}