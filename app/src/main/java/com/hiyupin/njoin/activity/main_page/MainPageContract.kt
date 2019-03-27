package com.hiyupin.njoin.activity.main_page

import com.hiyupin.njoin.pojo.user.UserModel

interface MainPageContract {
    interface MainPageView {

        fun showLoading()

        fun hideLoading()

        fun toDetailProduct(status: Boolean)

    }

    interface MainPagePresenter {
        fun getStatusProduct(
            barcode: String
        )
    }
}