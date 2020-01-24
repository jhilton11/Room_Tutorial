package com.appify.roomtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder>{
    private Context context;
    private List<ToDoItem> mItems;

    public ItemAdapter(List<ToDoItem> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_row_layout, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ToDoItem item = mItems.get(position);
        holder.nameTv.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        TextView nameTv;
        public Holder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_tv);
        }
    }

    public void setData(List<ToDoItem> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
