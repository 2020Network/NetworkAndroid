package com.example.studygorup;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MypageFragment extends Fragment implements View.OnClickListener{

    View view;

    private ViewPager viewPager;

    // region 변수 선언
    TextView textImg, textName, textGender, textAge, textField;
    Button btnProfile;
    // endregion

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage, container, false);

        // region 변수 연결
        textImg = view.findViewById(R.id.textImage);
        textName = view.findViewById(R.id.textName);
        textGender = view.findViewById(R.id.textGender);
        textAge = view.findViewById(R.id.textAge);
        textField = view.findViewById(R.id.textField);
        btnProfile = view.findViewById(R.id.btnEditProfile);
        // endregion

        btnProfile.setOnClickListener(this);

        viewPager = view.findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    public void setupViewPager(ViewPager viewPager){

        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new MypageGroupFragment(), "스터디그룹");
        adapter.addFragment(new MypageChatFragment(), "채팅");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditProfile:
                Intent intent = new Intent(getActivity(), ProfileEditActivity.class);
                startActivity(intent);
                break;
        }
    }
}