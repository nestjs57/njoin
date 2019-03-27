package com.hiyupin.njoin.activity.main_page

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hiyupin.njoin.model.Apis
import com.hiyupin.njoin.model.BaseURL
import com.hiyupin.njoin.pojo.pdstatus.ProductStatus
import com.hiyupin.njoin.pojo.user.UserModel
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.ArrayList

class MainPagePresenter(view: MainPageContract.MainPageView) : MainPageContract.MainPagePresenter {
    var baseURL: Apis? = null
    var view: MainPageContract.MainPageView? = null

    init {
        this.view = view
        baseURL = BaseURL.getBaseURL()
    }

    override fun getStatusProduct(barcode: String) {
        view?.showLoading()
        baseURL?.checkProductStatus(barcode)
            ?.enqueue(object : retrofit2.Callback<ProductStatus> {
                override fun onResponse(call: retrofit2.Call<ProductStatus>, response: Response<ProductStatus>) {
                    try {
                        view?.hideLoading()

                        var status: Boolean = response.body()!!.product_status
                        view?.toDetailProduct(status)

                    } catch (e: Exception) {
                        view?.hideLoading()
                    }
                }

                override fun onFailure(call: retrofit2.Call<ProductStatus>, t: Throwable) {
                }
            })
    }
}