package com.example.myapplication.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.RowFilterBinding;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder>{
    ArrayList<String> items = new ArrayList<>();
    OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowFilterBinding binding = RowFilterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = items.get(position);
        holder.setText(item);
        holder.setOnItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static interface OnItemClickListener {
        public void onItemClick(ViewHolder holder, View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RowFilterBinding binding;
        OnItemClickListener listener;

        public ViewHolder(@NonNull RowFilterBinding binding) {
            super(binding.getRoot());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null) listener.onItemClick(ViewHolder.this, v, position);
                }
            });
            this.binding = binding;
        }
        public void setText(String item) {
            binding.filterText.setText(item);
        }
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
        public TextView getItem() {
            return binding.filterText;
        }
    }

    public void addItem(String item){
        items.add(item);
    }

    public String getItem(int position){
        return items.get(position);
    }

    void changeItemSet(ArrayList<String> newList){
        items = newList;
    }
}
