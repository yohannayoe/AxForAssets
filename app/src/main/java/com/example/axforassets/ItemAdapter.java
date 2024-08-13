package com.example.axforassets;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> itemList;
    private Context context;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View v) {
            super(v);
            imageView = v.findViewById(R.id.itemView);
            textView = v.findViewById(R.id.itemName);
        }
    }

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.imageView.setImageResource(item.getImageResource());
        holder.textView.setText(item.getItemName());

        holder.itemView.findViewById(R.id.btnSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to start the SelectedItemActivity
                Intent intent = new Intent(context, SelectedItemActivity.class);

                // Put the selected item's variations, name, price, and description as extras in the Intent
                intent.putParcelableArrayListExtra("itemVariations", item.getVariations());
                intent.putExtra("itemName", item.getItemName());
                intent.putExtra("itemPrice", item.getItemPrice());
                intent.putExtra("itemDescription", item.getItemDescription());

                // Start the SelectedItemActivity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}