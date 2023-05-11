package com.dtech.darussalam.view.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.ActivityAuthBinding
import com.dtech.darussalam.databinding.FragmentTourThreeBinding
import com.dtech.darussalam.view.base.ActivityBase
import com.sangcomz.fishbun.BaseActivity

class AuthActivity : ActivityBase() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_auth)

        addFragment(R.id.authContainer , LoginFragment() , "")

    }
}