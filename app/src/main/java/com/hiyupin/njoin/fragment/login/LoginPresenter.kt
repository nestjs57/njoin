package com.hiyupin.njoin.fragment.login

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hiyupin.njoin.model.Apis
import com.hiyupin.njoin.model.BaseURL
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class LoginPresenter(view: LoginContract.loginView) : LoginContract.loginPresenter {

    var view: LoginContract.loginView? = null
    var baseURL: Apis? = null

    init {
        this.view = view
        baseURL = BaseURL.getBaseURL()
    }
    override fun getLogin() {
        view?.showLoading()
        baseURL?.getLogin("seecc0147@gmail.com")?.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                try {
//                    mData = ArrayList()
//                    mData = Gson().fromJson(response.body()!!.string(), object : TypeToken<List<Product>>() {
//                    }.type)
                    view?.hideLoading()
//                    view.showAllFilms(mData)
//                    view.onGetDataSuccess("", mData)
                } catch (e: Exception) {
                    view?.hideLoading()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
            }
        })
    }

}