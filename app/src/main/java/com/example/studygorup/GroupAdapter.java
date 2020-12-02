package com.example.studygorup;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.Holder> {

    private Context context;
    private List<GroupItemData> list = new ArrayList<>();
    private int groupType=0;

    public GroupAdapter(Context context, List<GroupItemData> list, int groupType) {
        this.context = context;
        this.list = list;
        this.groupType = groupType;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int rowLayout;

        switch (groupType){
            case 1:
                rowLayout = R.layout.group_row;
                break;
            case 2:
                rowLayout = R.layout.mypage_group_row;
                break;
            case 3:
                rowLayout = R.layout.mypage_chat_row;
                break;
            default:
                rowLayout = R.layout.group_row;
                break;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        Holder holder = new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        int itemposition = position;
        holder.textTitle.setText(list.get(itemposition).title);
        holder.textContents.setText(list.get(itemposition).contents);
        holder.textTag.setText(list.get(itemposition).tag);
        Log.d("TAG","onBindViewHolder"+itemposition);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Holder extends RecyclerView.ViewHolder{
        public TextView textTitle, textContents, textTag;

        public Holder(View view) {
            super(view);
            textTitle = view.findViewById(R.id.textTitle);
            textContents = view.findViewById(R.id.textContents);
            textTag = view.findViewById(R.id.textTag);
        }
    }
}