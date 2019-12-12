package com.example.firebaseauth.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebaseauth.entities.Panel;
import com.example.firebaseauth.R;
import com.example.firebaseauth.activities.PanelDetailsActivity;
import com.squareup.picasso.Picasso;
import java.util.List;

public class PanelAdapter extends RecyclerView.Adapter<PanelAdapter.PanelViewHolder> {

    private List<Panel> panelList;
    private Context context;

     public PanelAdapter(Context context, List<Panel> panelList){
         this.context = context;
         this.panelList = panelList;
    }

    @NonNull
    @Override
    public PanelAdapter.PanelViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                            final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_panel, parent, false);
        return new PanelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PanelViewHolder holder,
                                 final int position) {
        Picasso.get().load(panelList.get(position).getPhotoUrl()).into(holder.photoUrl);
        holder.panelType.setText(panelList.get(position).getModel());
        holder.power.setText(panelList.get(position).getPower());
        holder.capacity.setText(panelList.get(position).getCapacity());
        holder.address.setText(panelList.get(position).getAddress());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemDetails(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return panelList.size();
    }

    class PanelViewHolder extends RecyclerView.ViewHolder{

        private TextView panelType;
        private TextView power;
        private TextView capacity;
        private TextView address;
        private ImageView photoUrl;
        private LinearLayout parentLayout;

        private PanelViewHolder(final View itemView) {
            super(itemView);

            photoUrl = itemView.findViewById(R.id.item_panel_image_view);
            panelType =  itemView.findViewById(R.id.item_panel_type);
            power = itemView.findViewById(R.id.item_panel_power);
            capacity =  itemView.findViewById(R.id.item_panel_capacity);
            address =  itemView.findViewById(R.id.item_panel_address);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    private void openItemDetails(int position){
        Intent intent = new Intent(context, PanelDetailsActivity.class);
        intent.putExtra("panel_type", panelList.get(position).getModel());
        intent.putExtra("power", panelList.get(position).getPower());
        intent.putExtra("capacity", panelList.get(position).getCapacity());
        intent.putExtra("address", panelList.get(position).getAddress());
        intent.putExtra("image", panelList.get(position).getPhotoUrl());

        context.startActivity(intent);
    }
}