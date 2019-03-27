package com.hiyupin.njoin.activity.pddetail

import android.app.ActionBar
import android.support.design.widget.TabLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import com.hiyupin.njoin.R
import com.hiyupin.njoin.fragment.home.HomeFragment
import com.hiyupin.njoin.fragment.login.LoginFragment
import com.hiyupin.njoin.fragment.pddetail.comment.ProductCommentFragment
import com.hiyupin.njoin.fragment.pddetail.detail.ProductDetailFragment

class Product_Detail : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

        val tabLayout = findViewById<View>(R.id.tabs) as TabLayout

        mViewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mViewPager))

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return ProductDetailFragment()
                1 -> return ProductCommentFragment()
            }
            return null
        }

        override fun getCount(): Int {
            return 2
        }
    }
}
