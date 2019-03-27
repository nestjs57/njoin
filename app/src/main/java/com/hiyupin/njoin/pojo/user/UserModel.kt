package com.hiyupin.njoin.pojo.user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserModel(
    @SerializedName("user_id")
    @Expose
    var user_id: String,

    @SerializedName("user_email")
    @Expose
    var user_email: String,

    @SerializedName("user_password")
    @Expose
    var user_password: String,

    @SerializedName("user_fullname")
    @Expose
    var user_fullname: String,

    @SerializedName("user_gender")
    @Expose
    var user_gender: String,

    @SerializedName("user_nation")
    @Expose
    var user_nation: String,

    @SerializedName("status")
    @Expose
    var status: Int

) {
}