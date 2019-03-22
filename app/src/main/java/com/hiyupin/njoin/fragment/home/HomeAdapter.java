package com.hiyupin.njoin.fragment.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.hiyupin.njoin.R;
import com.hiyupin.njoin.pojo.home.ProductModel;
import com.hiyupin.njoin.pojo.home.PromotionModel;
import com.hiyupin.njoin.pojo.home.RootProductModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private ArrayList<RootProductModel> statusSet;
    private Runnable runable;
    private ProgressDialog progressDialog;
    private Intent intent;

    private static final int TYPE_TITLE = 0;
    private static final int TYPE_DETAIL = 1;


    public HomeAdapter(ArrayList<RootProductModel> statusSet) {
        this.statusSet = statusSet;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

//        View viewh = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_item, viewGroup, false);
//        final HomeViewHolder holder = new HomeViewHolder(viewh);
//
//        return holder;

        switch (i) {
            case TYPE_TITLE: {
                View viewh = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prouct_title_item, viewGroup, false);
                final HomeViewHolder holder = new HomeViewHolder(viewh);
                return holder;
            }
            case TYPE_DETAIL: {
                View viewh = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_item, viewGroup, false);
                final HomeViewHolder holder = new HomeViewHolder(viewh);
                return holder;
            }
            default:
                throw new IllegalArgumentException("Invalid view type");
        }
    }

    @Override
    public int getItemViewType(int position) {
//        Comparable element = .get(position);
        if (position == 0) {
            return TYPE_TITLE;
        } else {
            return TYPE_DETAIL;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, int i) {

        if (i != TYPE_TITLE) {
            final ProductModel data = statusSet.get(0).getProduct().get(i - 1);
            Glide.with(homeViewHolder.product_img)
                    .load(data.getProduct_img())
                    .centerCrop()
                    .into(homeViewHolder.product_img);

            homeViewHolder.product_name.setText(data.getProduct_name());
            homeViewHolder.product_detail.setText(data.getProduct_detail());

            homeViewHolder.product_rating.setRating(Float.parseFloat(String.valueOf(data.getProduct_total_rating())));

            homeViewHolder.product_view.setText(data.getProduct_total_scan() + " ครั้ง");
            homeViewHolder.product_price.setText(data.getProduct_total_price() + " บาท");
        }

        if (i == TYPE_TITLE) {
            final RootProductModel data_title = statusSet.get(0);
            Glide.with(homeViewHolder.ads_one)
                    .load(data_title.getPromotion().get(i).getPromotion_path())
                    .centerCrop()
                    .into(homeViewHolder.ads_one);

            Glide.with(homeViewHolder.ads_two)
                    .load(data_title.getPromotion().get(i+1).getPromotion_path())
                    .centerCrop()
                    .into(homeViewHolder.ads_two);

            Glide.with(homeViewHolder.ads_three)
                    .load(data_title.getPromotion().get(i+2).getPromotion_path())
                    .centerCrop()
                    .into(homeViewHolder.ads_three);
        }

    }

    @Override
    public int getItemCount() {
        return statusSet.size() + 2;
    }
}
