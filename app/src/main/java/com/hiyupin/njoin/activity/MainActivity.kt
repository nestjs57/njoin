package com.hiyupin.njoin.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chibatching.kotpref.Kotpref
import com.hiyupin.njoin.R
import com.hiyupin.njoin.UserConfig
import com.hiyupin.njoin.activity.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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