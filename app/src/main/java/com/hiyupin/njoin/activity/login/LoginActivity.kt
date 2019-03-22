package com.hiyupin.njoin.activity.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chibatching.kotpref.Kotpref
import com.hiyupin.njoin.R
import com.hiyupin.njoin.activity.MainActivity
import com.hiyupin.njoin.activity.register.RegisterActivity
import com.hiyupin.njoin.fragment.login.LoginContract
import com.hiyupin.njoin.fragment.login.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Kotpref.init(this)
        getSupportActionBar()?.hide();

        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.container, LoginFragment())
            .commit()
    }
}
