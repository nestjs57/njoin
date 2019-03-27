package com.hiyupin.njoin.pojo.pdstatus

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductStatus(
    @SerializedName("product_status")
    @Expose
    var product_status: Boolean
) {
}