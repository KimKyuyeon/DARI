package com.google.ar.core.examples.java.helloar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CommunityAdapter extends RecyclerView.Adapter<ViewHolder>{
    private ArrayList<CommunityListData> myDatalist = null;

    CommunityAdapter(ArrayList<CommunityListData> datalist){
        myDatalist = datalist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.community_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.comment_image.setImageResource(myDatalist.get(position).getImage_id());
        holder.comment_id.setText(myDatalist.get(position).getComment_id());
        holder.comment_title.setText(myDatalist.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return myDatalist.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    ImageView comment_image;
    TextView comment_id;
    TextView comment_title;

    ViewHolder(View itemView){
        super(itemView);

        comment_image = comment_image.findViewById(R.id.comment_image);
        comment_id = comment_id.findViewById(R.id.comment_id);
        comment_title = comment_title.findViewById(R.id.comment_title);
    }
}