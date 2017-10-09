package com.example.user.bloodbank;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 11/29/2016.
 */
public class View_Holder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView title;
    TextView description;
    TextView city;
    TextView mobile;
    ImageView imageView;


    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        city = (TextView) itemView.findViewById(R.id.city);
        mobile = (TextView) itemView.findViewById(R.id.mobile);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}
