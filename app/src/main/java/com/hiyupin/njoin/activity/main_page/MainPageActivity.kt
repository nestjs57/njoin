package com.hiyupin.njoin.activity.main_page

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.chibatching.kotpref.Kotpref
import com.hiyupin.njoin.R
import com.hiyupin.njoin.UserConfig
import com.hiyupin.njoin.activity.login.LoginActivity
import com.hiyupin.njoin.fragment.home.HomeFragment
import com.hiyupin.njoin.fragment.notification.NotificationFragment
import com.hiyupin.njoin.fragment.profile.ProfileFragment
import com.hiyupin.njoin.fragment.review.ReviewFragment
import kotlinx.android.synthetic.main.activity_main_page.*

class MainPageActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_review -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ReviewFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, NotificationFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ProfileFragment())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        Kotpref.init(this)
        getSupportActionBar()?.hide();
        InitialLogin()

    }

    fun InitialLogin() {
        when (UserConfig.status_login) {
            0 -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
