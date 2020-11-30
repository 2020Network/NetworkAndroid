package com.example.studygorup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class NoticeFileActivity extends AppCompatActivity {

    private ViewPager viewPager;
    SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());

    private static Typeface type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_file);

        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager){
        adapter.addFragment(new NoticeFragment(), "공지");
        adapter.addFragment(new FileFragment(), "파일");
        viewPager.setAdapter(adapter);
    }
}