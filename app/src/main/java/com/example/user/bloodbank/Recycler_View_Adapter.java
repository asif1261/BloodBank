package com.example.user.bloodbank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by user on 11/28/2016.
 */

public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Data>list = Collections.emptyList();
    Context context;

    public Recycler_View_Adapter(List<Data>list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);

        View_Holder holder = new View_Holder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {
        holder.title.setText(list.get(position).title);
        holder.description.setText(list.get(position).description);
        holder.city.setText(list.get(position).city);
        holder.mobile.setText(list.get(position).mobile);
        holder.imageView.setImageResource(list.get(position).imageId);

        //animate(holder);
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }



//    public void animate(RecyclerView.ViewHolder viewHolder) {
//        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.bounce_interpolator);
//        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
//    }
}
