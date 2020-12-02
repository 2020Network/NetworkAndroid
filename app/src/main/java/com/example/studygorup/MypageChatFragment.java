package com.example.studygorup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MypageChatFragment extends Fragment implements View.OnClickListener{
    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private ArrayList<GroupItemData> list = new ArrayList<>();

    TextView textTitle, textContent, textTag;
    Button btnExit;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_chat, container, false);

        textTitle = view.findViewById(R.id.textTitle);
        textContent = view.findViewById(R.id.textContents);
        textTag = view.findViewById(R.id.textTag);
        btnExit = view.findViewById(R.id.btnExit);

        /*btnExit.setOnClickListener(this);*/

        recyclerView = view.findViewById(R.id.recycler);

        list = GroupItemData.createGroupList(2);
        recyclerView.setHasFixedSize(true);
        adapter = new GroupAdapter(getContext(),list,3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnExit:
                break;
        }
    }
}