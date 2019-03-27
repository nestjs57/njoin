package com.hiyupin.njoin.pojo.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductDetailModel(
    @SerializedName("product_id")
    @Expose
    var product_id: String,

    @SerializedName("product_name")
    @Expose
    var product_name: String,

    @SerializedName("product_detail")
    @Expose
    var product_detail: String,

    @SerializedName("product_img")
    @Expose
    var product_img: String,

    @SerializedName("product_type")
    @Expose
    var product_type: String,

    @SerializedName("product_date")
    @Expose
    var product_date: String,

    @SerializedName("product_total_rating")
    @Expose
    var product_total_rating: Int,

    @SerializedName("product_total_comment")
    @Expose
    var product_total_comment: Int,

    @SerializedName("product_total_price")
    @Expose
    var product_total_price: Int,

    @SerializedName("product_total_scan")
    @Expose
    var product_total_scan: Int,

    @SerializedName("product_location")
    @Expose
    var product_location: String
) {

}