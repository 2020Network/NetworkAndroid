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

import com.example.studygorup.API.GroupAPI;
import com.example.studygorup.API.RetrofitHelper;
import com.example.studygorup.DTO.Responsegroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private GroupAdapter adapter;
    private ArrayList<GroupItemData> list = new ArrayList<>();
    GroupAPI service = new RetrofitHelper().getGroupAPI();

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

        service.allgroup().enqueue(new Callback<List<Responsegroup>>() {
            @Override
            public void onResponse(Call<List<Responsegroup>> call, Response<List<Responsegroup>> response) {
                if (response.isSuccessful()){
                    list = GroupItemData.createGroupList(10);
                    recyclerView.setHasFixedSize(true);
                    adapter = new GroupAdapter(getContext(),list,1);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Responsegroup>> call, Throwable t) {

            }
        });

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