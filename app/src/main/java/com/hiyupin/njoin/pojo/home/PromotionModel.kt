package com.hiyupin.njoin.pojo.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PromotionModel(
    @SerializedName("promotion_path")
    @Expose
    var promotion_path: String,

    @SerializedName("promotion_link")
    @Expose
    var promotion_link: String

) {
}