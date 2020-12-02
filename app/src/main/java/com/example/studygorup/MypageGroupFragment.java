package com.example.studygorup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MypageGroupFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private ArrayList<GroupItemData> list = new ArrayList<>();

    TextView textTitle, textContent, textTag;
    Button btnModify, btnDelete;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_group, container, false);

        textTitle = view.findViewById(R.id.textTitle);
        textContent = view.findViewById(R.id.textContents);
        textTag = view.findViewById(R.id.textTag);
        btnModify = view.findViewById(R.id.btnModify);
        btnDelete = view.findViewById(R.id.btnDelete);

        /*btnModify.setOnClickListener(this);
        btnDelete.setOnClickListener(this);*/

        recyclerView = view.findViewById(R.id.recycler);

        list = GroupItemData.createGroupList(5);
        recyclerView.setHasFixedSize(true);
        adapter = new GroupAdapter(getContext(),list,2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnModify:
                break;
            case R.id.btnDelete:
                break;
        }
    }
}