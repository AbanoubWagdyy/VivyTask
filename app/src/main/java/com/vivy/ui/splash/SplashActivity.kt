package com.vivy.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.vivy.R
import com.vivy.ui.login.LoginActivity
import com.vivy.di.base.BaseActivity

class SplashActivity : BaseActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1500

    override fun layoutRes(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}