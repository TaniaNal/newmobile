package com.example.laba3;

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
import com.squareup.picasso.Picasso;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.PanelViewHolder> {

    private List<Movies> panelList;
    private Context context;

     public MoviesAdapter(Context context, List<Movies> panelList){
         this.context = context;
         this.panelList = panelList;
    }

    @NonNull
    @Override
    public MoviesAdapter.PanelViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                                            final int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.panel, parent, false);
        return new PanelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PanelViewHolder holder,
                                 final int position) {
        Picasso.get().load(panelList.get(position).getPoster()).into(holder.poster);
        holder.title.setText(panelList.get(position).getTitle());
        holder.year.setText(panelList.get(position).getYear());
        holder.description.setText(panelList.get(position).getDescription());
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

        private TextView title;
        private TextView year;
        private TextView description;
        private ImageView poster;
        private LinearLayout parentLayout;

        private PanelViewHolder(final View itemView) {
            super(itemView);

            poster = itemView.findViewById(R.id.item_panel_image_view);
            title =  itemView.findViewById(R.id.item_panel_type);
            year = itemView.findViewById(R.id.item_panel_year);
            description =  itemView.findViewById(R.id.item_panel_description);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    private void openItemDetails(int position){
        Intent intent = new Intent(context, MoviesDetails.class);
        intent.putExtra("title", panelList.get(position).getTitle());
        intent.putExtra("year", panelList.get(position).getYear());
        intent.putExtra("description", panelList.get(position).getDescription());
        intent.putExtra("poster", panelList.get(position).getPoster());

        context.startActivity(intent);
    }
}