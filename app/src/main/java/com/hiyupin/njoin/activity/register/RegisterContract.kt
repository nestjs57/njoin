package com.hiyupin.njoin.activity.register

import com.hiyupin.njoin.pojo.user.UserModel

interface RegisterContract {

    interface registerView {

        fun showLoading()

        fun hideLoading()

        fun closeActivity()

        fun registerFail()

        fun setDataUser(list: ArrayList<UserModel>)
    }

    interface registerPresenter {
        fun getRegister(
            email: String,
            password: String,
            fullname: String
        )
    }
}