package com.example.studygorup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private ArrayList<GroupItemData> list = new ArrayList<>();

    TextView textTitle, textContent, textTag;
    ImageView makeGroupBtn;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_group, container, false);

        textTitle = view.findViewById(R.id.textTitle);
        textContent = view.findViewById(R.id.textContents);
        textTag = view.findViewById(R.id.textTag);
        makeGroupBtn = view.findViewById(R.id.makeGroup);

        makeGroupBtn.setOnClickListener(this);

        recyclerView = view.findViewById(R.id.recycler);

        list = GroupItemData.createGroupList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new GroupAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        Log.d("TAG", "Group Fragment");
        
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.makeGroup:
                Intent intent = new Intent(getContext(), PostContentActivity.class);
                startActivity(intent);
                break;
        }
    }
}