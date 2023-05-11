package com.dtech.darussalam.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dtech.darussalam.R
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.main.MainActivity
import com.dtech.darussalam.view.tour.TourActivity

class SplashActivity : ActivityBase() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }
}

