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

    public GroupAdapter(Context context, List<GroupItemData> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_row, parent, false);
        Holder holder = new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        int itemposition = position;
        holder.textTitle.setText(list.get(itemposition).title);
        holder.textContents.setText(list.get(itemposition).contents);
        Log.d("TAG","onBindViewHolder"+itemposition);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Holder extends RecyclerView.ViewHolder{
        public TextView textTitle, textContents;

        public Holder(View view) {
            super(view);
            textTitle = view.findViewById(R.id.textTitle);
            textContents = view.findViewById(R.id.textContents);
        }
    }
}