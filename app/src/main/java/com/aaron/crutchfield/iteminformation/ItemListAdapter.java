package com.aaron.crutchfield.iteminformation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aaron.crutchfield.iteminformation.data.ItemEntry;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aaron Crutchfield on 6/22/2018.
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder> {

    private List<ItemEntry> itemEntryList;

    public ItemListAdapter() {
        this.itemEntryList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_item_details, parent, false);
        return new ItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return itemEntryList.size();
    }

    public void updateList(List<ItemEntry> itemEntryList) {
        this.itemEntryList = itemEntryList;
        notifyDataSetChanged();
    }

    class ItemListViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;
        private TextView tvDescription;
        private TextView tvLocation;

        ItemListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvLocation = itemView.findViewById(R.id.tv_location);
        }

        void bindView(int position) {
            ItemEntry itemEntry = itemEntryList.get(position);
            tvItem.setText(itemEntry.getItem());
            tvDescription.setText(itemEntry.getDescription());
            tvLocation.setText(itemEntry.getDefaultLocation());
            Log.d("ItemListViewHolder", "bindView: " + itemEntry.getDefaultLocation());
        }
    }
}
