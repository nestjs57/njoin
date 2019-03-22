package com.hiyupin.njoin.fragment.home

import com.hiyupin.njoin.pojo.home.RootProductModel

interface HomeContract {

    interface homeView {

        fun showLoading()

        fun hideLoading()

        fun sendDataToRecyclerview(mData : ArrayList<RootProductModel>)

//        fun showAllFilms(Product: List<Product>)
//
//        fun navigateToFilmPage()
//
//        fun onGetDataSuccess(message: String, list: ArrayList<Product>)

    }

    interface homePresenter {

        fun getItem()

    }
}