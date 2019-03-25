package com.hiyupin.njoin.fragment.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.agrawalsuneet.dotsloader.loaders.LazyLoader
import com.hiyupin.njoin.R
import com.hiyupin.njoin.pojo.home.ProductModel
import com.hiyupin.njoin.pojo.home.RootProductModel

import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeContract.homeView {

    private var recyclerView: RecyclerView? = null
    private var progress: LazyLoader? = null
    private val dataSet: ArrayList<ProductModel>? = null
    private var adapter: HomeAdapter? = null
    private var mLayoutManager: LinearLayoutManager? = null

    private var homePresenter: HomePresenter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        homePresenter = HomePresenter(this)
        homePresenter!!.getItem()

        recyclerView = view.findViewById<View>(R.id.rvProduct) as RecyclerView
        progress = view.findViewById<View>(R.id.progress) as LazyLoader
        //        dataSet = new ArrayList<ProductModel>();

        return view
    }

    override fun showLoading() {

        //        progress.setVisibility(View.VISIBLE);
    }

    override fun hideLoading() {
        progress!!.visibility = View.GONE
    }

    override fun sendDataToRecyclerview(mData: ArrayList<RootProductModel>) {
        adapter = HomeAdapter(mData)

        mLayoutManager = LinearLayoutManager(activity)

        //        mLayoutManager.setReverseLayout(true);
        //        mLayoutManager.scrollToPositionWithOffset(0, 0);

        //        mLayoutManager.setStackFromEnd(true);
        recyclerView!!.layoutManager = mLayoutManager

        recyclerView!!.adapter = adapter

    }
}// Required empty public constructor
