package com.example.studygorup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChattingActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView goNoFiBtn, addBtn, sendBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        goNoFiBtn = findViewById(R.id.goNoFiBtn);
        addBtn = findViewById(R.id.addBtn);
        sendBtn = findViewById(R.id.sendBtn);

        goNoFiBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goNoFiBtn:
                Intent intent = new Intent(getApplicationContext(), NoticeFileActivity.class);
                startActivity(intent);
                break;
            case R.id.addBtn:
                break;
            case R.id.sendBtn:
                break;
        }
    }
}