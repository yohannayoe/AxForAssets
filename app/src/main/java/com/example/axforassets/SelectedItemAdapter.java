package com.example.axforassets;

import android.content.Context;
//import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectedItemAdapter extends RecyclerView.Adapter<SelectedItemAdapter.ItemViewHolder> {

    private ArrayList<Item> itemList;
    private Context context;

    public SelectedItemAdapter(ArrayList<Item> itemList, Context context) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditemshow, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItemIcon;
        TextView tvItemName;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItemIcon = itemView.findViewById(R.id.itemImageSmall);
            tvItemName = itemView.findViewById(R.id.itemNameSmall);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.ivItemIcon.setImageResource(item.getImageResource());
        holder.tvItemName.setText(item.getItemName());
        // Scale the image
        holder.ivItemIcon.setScaleX(2f); // scale in X direction
        holder.ivItemIcon.setScaleY(2f); // scale in Y direction


        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        layoutParams.width = RecyclerView.LayoutParams.WRAP_CONTENT;
        layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(100, 16, 100, 16);
        holder.itemView.setLayoutParams(layoutParams);
    }
}
