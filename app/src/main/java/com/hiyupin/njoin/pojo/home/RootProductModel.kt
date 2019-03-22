package com.hiyupin.njoin.pojo.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RootProductModel(
    @SerializedName("product")
    @Expose
    var product: ArrayList<ProductModel>,

    @SerializedName("promotion")
    @Expose
    var promotion: ArrayList<PromotionModel>


) {
}