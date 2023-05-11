package com.dtech.darussalam.view.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.ActivityMainBinding
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.main.customer.MainFragment
import com.dtech.darussalam.view.main.customer.MoreFragment

class MainActivity : ActivityBase() ,View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        setListener()
        addFragment(R.id.mainContainer , MainFragment() , "")

    }
    private fun setListener(){
      /*  binding.clHome.setOnClickListener(this)
        binding.clFavourites.setOnClickListener(this)
        binding.clMore.setOnClickListener(this)*/

    }


    override fun onClick(v: View?) {
        when(v!!.id){

          /*  R.id.clHome ->{

                addFragment(R.id.mainContainer , HomeCustomerFragment() , "")
            }
            R.id.clFavourites ->{
                addFragment(R.id.mainContainer , FavouritesFragment() , "")
            }
            R.id.clMore ->{
                addFragment(R.id.mainContainer , MoreFragment() , "")
            }*/

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (val fragment = activity.supportFragmentManager.findFragmentById(R.id.mainContainer)) {
            is MainFragment -> {
                fragment.onActivityResult(requestCode, resultCode, data)
            }

            else -> {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }

    }

}