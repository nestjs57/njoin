package com.hiyupin.njoin.activity.register

import android.content.Context
import android.support.design.widget.Snackbar
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hiyupin.njoin.fragment.RegisterContract
import com.hiyupin.njoin.fragment.login.LoginContract
import com.hiyupin.njoin.model.Apis
import com.hiyupin.njoin.model.BaseURL
import com.hiyupin.njoin.pojo.UserModel
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.ArrayList
import javax.security.auth.callback.Callback

class RegisterPresenter(view: com.hiyupin.njoin.activity.register.RegisterContract.registerView) :
    com.hiyupin.njoin.activity.register.RegisterContract.registerPresenter {

    var baseURL: Apis? = null
    var view: com.hiyupin.njoin.activity.register.RegisterContract.registerView? = null
    var mData: ArrayList<UserModel>? = null

    init {
        this.view = view
        baseURL = BaseURL.getBaseURL()
    }

    override fun getRegister(email: String, password: String, fullname: String) {
        view?.showLoading()
        baseURL?.getRegister(email, password, fullname)
            ?.enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                    try {
                        view?.hideLoading()
                        mData = ArrayList()
                        mData = Gson().fromJson(response.body()!!.string(), object : TypeToken<List<UserModel>>() {
                        }.type)

                        when (mData!![0].status) {
                            0 -> {
                                view?.setDataUser(mData!!)
                            }
                            1 -> view?.registerFail()
                        }

                    } catch (e: Exception) {
                        view?.hideLoading()
                    }
                }

                override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                }
            })

    }
}