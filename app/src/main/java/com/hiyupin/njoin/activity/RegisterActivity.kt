package com.hiyupin.njoin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hiyupin.njoin.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        getSupportActionBar()?.hide();

    }
}
