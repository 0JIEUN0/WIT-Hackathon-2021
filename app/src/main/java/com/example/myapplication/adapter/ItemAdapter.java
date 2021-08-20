package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.myapplication.data.Item;
import com.example.myapplication.databinding.RowFilterBinding;
import com.example.myapplication.databinding.RowItemBinding;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    ArrayList<Item> items = new ArrayList<>();
    OnItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowItemBinding binding = RowItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.setItem(item);
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

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RowItemBinding binding;
        OnItemClickListener listener;
        Item item;

        public ViewHolder(@NonNull RowItemBinding binding) {
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
        public void setItem(Item item) {
            item = item;
            binding.title.setText(item.getTitle());
            binding.price.setText(item.getPrice());
            binding.rating.setText(String.valueOf(item.getRating()));
            binding.number.setText(item.getNumber());
            binding.imageView.setImageDrawable(item.getImage());
        }
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
        public Item getItem(){
            return item;
        }
    }

    public void addItem(Item item){
        items.add(item);
    }
    void changeItemSet(ArrayList<Item> newList){
        items = newList;
    }
}
