package com.dtech.darussalam.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentSignUpBinding
import com.dtech.darussalam.view.base.BaseFragment

class SignUpFragment: BaseFragment() {

    lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_sign_up , container , false)
        setListener()

        return binding.root
    }
    private fun setListener(){

    }
}