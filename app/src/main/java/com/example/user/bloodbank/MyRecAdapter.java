package com.example.user.bloodbank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/13/2016.
 */


    public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.VH> {
        public List<Post> parkingList;

        public Context context;
        ArrayList<Post> mCountryModel;

        public MyRecAdapter(List<Post> parkingList, Context context) {
            this.parkingList = parkingList;
            this.context = context;
        }


        @Override
        public MyRecAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyRecAdapter.VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycardview, parent, false));
        }

        @Override
        public void onBindViewHolder(MyRecAdapter.VH holder, int position) {
            holder.t1.setText(parkingList.get(position).getPostTitle());
            holder.t2.setText(parkingList.get(position).getPostSubTitle());
            holder.t3.setText(parkingList.get(position).getPostCity());
            holder.t4.setText(parkingList.get(position).getPostMobile());
            holder.i1.setImageResource(parkingList.get(position).getPostImage());


        }

        @Override
        public int getItemCount() {
            return parkingList.size();
        }

        public class VH extends RecyclerView.ViewHolder {
            TextView t1, t2,t3,t4;
            ImageView i1;

            public VH(View itemView) {
                super(itemView);
                t1 = (TextView) itemView.findViewById(R.id.list_title);
                t2 = (TextView) itemView.findViewById(R.id.list_desc);
                t3 = (TextView) itemView.findViewById(R.id.list_city);
                t4 = (TextView) itemView.findViewById(R.id.list_mobile);
                i1 = (ImageView) itemView.findViewById(R.id.list_avatar);
            }
        }

        public void setFilter(List<Post> countryModels) {
            mCountryModel = new ArrayList<>();
            mCountryModel.addAll(countryModels);
            notifyDataSetChanged();
        }
}
