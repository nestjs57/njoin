package com.hiyupin.njoin.model

import com.hiyupin.njoin.pojo.pdstatus.ProductStatus
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface Apis {
    @GET("dev/admin/files/api/njoin_api/login.php")
    fun getLogin(@Query("email") email: String): Call<ResponseBody>

    @GET("dev/admin/files/api/njoin_api/register.php")
    fun getRegister(
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("fullname") fullname: String
    ): Call<ResponseBody>

    @GET("dev/admin/files/api/njoin_api/query_product.php")
    fun getProduct(): Call<ResponseBody>

    @GET("dev/admin/files/api/njoin_api/check_product.php")
    fun checkProductStatus(@Query("barcode_id") barcode_id: String): Call<ProductStatus>
}