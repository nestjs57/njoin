package com.hiyupin.njoin.fragment.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.hiyupin.njoin.R

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var ads_one: ImageButton? = null
    var ads_two: ImageButton? = null
    var ads_three: ImageButton? = null

    var linear_bg: LinearLayout? = null
    var product_img: ImageView? = null
    var product_name: TextView? = null
    var product_detail: TextView? = null
    var product_rating: RatingBar? = null
    var product_view: TextView? = null
    var product_price: TextView? = null

    init {

        this.ads_one = itemView.findViewById<ImageButton>(R.id.ads_one)
        this.ads_two = itemView.findViewById<ImageButton>(R.id.ads_two)
        this.ads_three = itemView.findViewById<ImageButton>(R.id.ads_three)

        this.linear_bg = itemView.findViewById<LinearLayout>(R.id.linear_bg)
        this.product_img = itemView.findViewById<ImageView>(R.id.product_img)
        this.product_name = itemView.findViewById<TextView>(R.id.product_name)
        this.product_detail = itemView.findViewById<TextView>(R.id.product_detail)
        this.product_rating = itemView.findViewById<RatingBar>(R.id.product_rating)
        this.product_view = itemView.findViewById<TextView>(R.id.product_view)
        this.product_price = itemView.findViewById<TextView>(R.id.product_price)

    }
}
