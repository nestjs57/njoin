package com.hiyupin.njoin.fragment.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.hiyupin.njoin.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    ImageButton ads_one;
    ImageButton ads_two;
    ImageButton ads_three;

    ImageView product_img;
    TextView product_name;
    TextView product_detail;
    RatingBar product_rating;
    TextView product_view;
    TextView product_price;


    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);

        ads_one = itemView.findViewById(R.id.ads_one);
        ads_two = itemView.findViewById(R.id.ads_two);
        ads_three = itemView.findViewById(R.id.ads_three);

        product_img = itemView.findViewById(R.id.product_img);
        product_name = itemView.findViewById(R.id.product_name);
        product_detail = itemView.findViewById(R.id.product_detail);
        product_rating = itemView.findViewById(R.id.product_rating);
        product_view = itemView.findViewById(R.id.product_view);
        product_price = itemView.findViewById(R.id.product_price);

    }
}
