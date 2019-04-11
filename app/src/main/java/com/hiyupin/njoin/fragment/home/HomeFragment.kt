package com.hiyupin.njoin.fragment.home


import android.annotation.SuppressLint
import android.graphics.Color
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar


import com.hiyupin.njoin.pojo.home.ProductModel
import com.hiyupin.njoin.pojo.home.RootProductModel

import java.util.ArrayList

import com.facebook.shimmer.ShimmerFrameLayout
import com.hiyupin.njoin.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), HomeContract.homeView {

    private var recyclerView: RecyclerView? = null
    private var progress: ProgressBar? = null
    private val dataSet: ArrayList<ProductModel>? = null
    private var adapter: HomeAdapter? = null
    private var mLayoutManager: LinearLayoutManager? = null
    private var homePresenter: HomePresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(com.hiyupin.njoin.R.layout.fragment_home, container, false)

        homePresenter = HomePresenter(this)
        homePresenter!!.getItem()

        recyclerView = view.findViewById<View>(com.hiyupin.njoin.R.id.rvProduct) as RecyclerView
        progress = view.findViewById<View>(R.id.progress) as ProgressBar
        //        dataSet = new ArrayList<ProductModel>();


//        container.stopShimmer()
//        container.startShimmer() // If auto-start is set to false
        return view

    }

    override fun showLoading() {
        //        progress.setVisibility(View.VISIBLE);
    }

    override fun hideLoading() {
//        progress!!.visibility = View.GONE
//        container = view?.findViewById<View>(R.id.shimmer_view_container) as ShimmerFrameLayout
        try {
            shimmer_view_container.visibility = View.GONE
        } catch (c: Exception) {

        }

        //skeletonScreen?.hide()
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
