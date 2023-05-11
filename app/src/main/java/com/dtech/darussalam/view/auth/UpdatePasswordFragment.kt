package com.dtech.darussalam.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentUpdatePasswordBinding
import com.dtech.darussalam.utilities.extensions.showToastMessage
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment

class UpdatePasswordFragment: BaseFragment() , View.OnClickListener {

    lateinit var binding: FragmentUpdatePasswordBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_update_password , container , false)

        setListener()

        return binding.root
    }
    private fun setListener(){

        binding.btnResetNow.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnResetNow ->{
                if (validation()){
                    addFragment(R.id.authContainer , LoginFragment() , "LoginFragment")
                }
            }
        }
    }
    private fun validation() : Boolean {
        if (binding.edtPassword.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.edtPassword.requestFocus()
            return false
        } else   if (binding.edtConfirmPassword.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.edtConfirmPassword.requestFocus()
            return false
        }else   if (binding.edtConfirmPassword.text.toString() != binding.edtPassword.text.toString()){
            ActivityBase.activity.showToastMessage(getString(R.string.password_not_match))
            binding.edtPassword.setText("")
            binding.edtConfirmPassword.setText("")
            binding.edtPassword.requestFocus()
            return false
        }
        return true
    }
}