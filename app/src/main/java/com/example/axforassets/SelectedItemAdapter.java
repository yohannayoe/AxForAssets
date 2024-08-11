package com.example.axforassets;

import android.content.ClipData;
import android.content.Context;
import android.media.RouteListingPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.axforassets.R;
import com.example.axforassets.SelectedItem;

import java.util.List;

public class SelectedItemAdapter extends RecyclerView.Adapter<SelectedItemAdapter.ItemViewHolder> {

    private List<SelectedItem> itemList;


    private Context context;

    public SelectedItemAdapter(List<SelectedItem> itemList, Context context) {
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
        SelectedItem item = itemList.get(position);
        holder.ivItemIcon.setImageResource(item.getRouteId());
        holder.tvItemName.setText(item.getName());

        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        layoutParams.width = RecyclerView.LayoutParams.WRAP_CONTENT;
        layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT;
        layoutParams.setMargins(100, 16, 100, 16);
        holder.itemView.setLayoutParams(layoutParams);
    }
}
