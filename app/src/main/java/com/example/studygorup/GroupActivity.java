package com.example.studygorup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private ArrayList<GroupItemData> list = new ArrayList<>();

    TextView textTitle, textContent, textTag;
    ImageView makeGroupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        textTitle = findViewById(R.id.textTitle);
        textContent = findViewById(R.id.textContents);
        textTag = findViewById(R.id.textTag);
        makeGroupBtn = findViewById(R.id.makeGroup);

        makeGroupBtn.setOnClickListener(this);

        recyclerView = findViewById(R.id.recycler);

        list = GroupItemData.createGroupList(10);
        recyclerView.setHasFixedSize(true);
        adapter = new GroupAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Log.d("TAG", "Group Fragment");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.makeGroup:
                Intent intent = new Intent(getApplicationContext(), PostContentActivity.class);
                startActivity(intent);
                break;
        }
    }
}