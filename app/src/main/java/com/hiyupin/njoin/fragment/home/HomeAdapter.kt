package com.hiyupin.njoin.fragment.home

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hiyupin.njoin.R
import com.hiyupin.njoin.pojo.home.RootProductModel
import com.thekhaeng.pushdownanim.PushDownAnim

import java.util.ArrayList

import com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE
import android.view.animation.AnimationUtils


class HomeAdapter(private val statusSet: ArrayList<RootProductModel>) : RecyclerView.Adapter<HomeViewHolder>() {

    private val intent: Intent? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HomeViewHolder {

        when (i) {
            TYPE_TITLE -> {
                val viewh = LayoutInflater.from(viewGroup.context).inflate(R.layout.prouct_title_item, viewGroup, false)
                return HomeViewHolder(viewh)
            }
            TYPE_DETAIL -> {
                val viewh = LayoutInflater.from(viewGroup.context).inflate(R.layout.product_item, viewGroup, false)
                return HomeViewHolder(viewh)
            }
            else -> throw IllegalArgumentException("Invalid view type") as Throwable
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_TITLE
        } else {
            TYPE_DETAIL
        }
    }

    override fun onBindViewHolder(homeViewHolder: HomeViewHolder, i: Int) {

        if (i != TYPE_TITLE) {
            val data = statusSet[0].product[i - 1]
            Glide.with(homeViewHolder.product_img!!)
                .load(data.product_img)
                .centerCrop()
                .into(homeViewHolder.product_img!!)

            homeViewHolder.product_name?.text = data.product_name
            homeViewHolder.product_detail?.text = data.product_detail

            homeViewHolder.product_rating?.rating = java.lang.Float.parseFloat(data.product_total_rating.toString())

            homeViewHolder.product_view?.text = data.product_total_scan.toString() + " ครั้ง"
            homeViewHolder.product_price?.text = data.product_total_price.toString() + " บาท"

            PushDownAnim.setPushDownAnimTo(homeViewHolder.linear_bg)
                .setScale(MODE_SCALE, 0.95f)
                .setOnClickListener { }
        }

        if (i == TYPE_TITLE) {
            val data_title = statusSet[0]

            //set image with glide
            Glide.with(homeViewHolder.ads_one!!)
                .load(data_title.promotion[i].promotion_path)
                .centerCrop()
                .into(homeViewHolder.ads_one!!)

            Glide.with(homeViewHolder.ads_two!!)
                .load(data_title.promotion[i + 1].promotion_path)
                .centerCrop()
                .into(homeViewHolder.ads_two!!)

            Glide.with(homeViewHolder.ads_three!!)
                .load(data_title.promotion[i + 2].promotion_path)
                .centerCrop()
                .into(homeViewHolder.ads_three!!)

            //set pushdown on click
            PushDownAnim.setPushDownAnimTo(homeViewHolder.ads_one)
                .setScale(MODE_SCALE, 0.95f)
                .setOnClickListener { }

            PushDownAnim.setPushDownAnimTo(homeViewHolder.ads_two)
                .setScale(MODE_SCALE, 0.95f)
                .setOnClickListener { }

            PushDownAnim.setPushDownAnimTo(homeViewHolder.ads_three)
                .setScale(MODE_SCALE, 0.95f)
                .setOnClickListener { }
        }
    }

    override fun getItemCount(): Int {
        return statusSet.size + 2
    }

    companion object {

        private val TYPE_TITLE = 0
        private val TYPE_DETAIL = 1
    }
}
