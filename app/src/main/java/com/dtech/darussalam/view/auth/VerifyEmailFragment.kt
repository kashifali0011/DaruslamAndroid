package com.dtech.darussalam.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentVerifyEamailBinding
import com.dtech.darussalam.utilities.extensions.showToastMessage
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment

class VerifyEmailFragment: BaseFragment() , View.OnClickListener{

    lateinit var binding: FragmentVerifyEamailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_verify_eamail , container , false)

        setListener()
        return binding.root
    }

    private fun setListener(){
      binding.btnVerifyEmail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnVerifyEmail ->{
                if (validateInput()){
                    addFragment(R.id.authContainer , VerifyOtpFragment() , "VerifyOtpFragment")
                }

            }
        }
    }

    private fun validateInput() : Boolean{
        if (binding.edEmailAddress.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.edEmailAddress.requestFocus()
            return false
        }
        return true
    }
}