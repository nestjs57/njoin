package com.hiyupin.njoin.fragment.home

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hiyupin.njoin.model.Apis
import com.hiyupin.njoin.model.BaseURL
import com.hiyupin.njoin.pojo.UserModel
import com.hiyupin.njoin.pojo.home.RootProductModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(view: HomeContract.homeView) : HomeContract.homePresenter {

    var view: HomeContract.homeView? = null
    var baseURL: Apis? = null
    var mData: java.util.ArrayList<RootProductModel>? = null


    init {
        this.view = view
        baseURL = BaseURL.getBaseURL()
    }

    override fun getItem() {
        view?.showLoading()
        baseURL?.getProduct()?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {
                    mData = ArrayList()
                    mData =
                        Gson().fromJson(response.body()!!.string(), object : TypeToken<ArrayList<RootProductModel>>() {
                        }.type)
                    view?.hideLoading()
                    mData?.let { view?.sendDataToRecyclerview(it) }
                } catch (e: Exception) {
                    view?.hideLoading()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                view?.hideLoading()
            }
        })
    }
}