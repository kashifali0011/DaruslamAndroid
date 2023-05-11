package com.dtech.darussalam.view.auth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentLoginBinding
import com.dtech.darussalam.utilities.extensions.showToastMessage
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.MainActivity

class LoginFragment: BaseFragment() , View.OnClickListener {

    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_login , container , false)
        setListener()
        return binding.root
    }
    private fun setListener(){
        binding.tvSignUp.setOnClickListener(this)
        binding.tvForgetPassword.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
      when(v!!.id){
          R.id.tvSignUp ->{
              addFragment(R.id.authContainer , SignUpFragment(), "SignUpFragment" )
          }
          R.id.tvForgetPassword ->{
              addFragment(R.id.authContainer , VerifyEmailFragment() , "VerifyEmailFragment")
          }
          R.id.btnLogin ->{

              if (validateInput()){
                  var intent = Intent(ActivityBase.activity , MainActivity::class.java)
                  intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                  startActivity(intent)
                  ActivityBase.activity.finish()
              }else{

              }
          }
      }

    }

    private fun validateInput() : Boolean{
        if (binding.edEmailAddress.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.edEmailAddress.requestFocus()
            return false
        } else   if (binding.edPassword.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.edPassword.requestFocus()
            return false
        }
        return true
    }
}