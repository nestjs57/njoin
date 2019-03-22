package com.hiyupin.njoin.fragment.login

import java.util.ArrayList

interface LoginContract {
    interface loginView {

        fun showLoading()

        fun hideLoading()

    }

    interface loginPresenter {

        fun getLogin()

    }
}