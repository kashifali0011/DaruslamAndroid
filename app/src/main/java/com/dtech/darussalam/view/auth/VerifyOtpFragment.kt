package com.dtech.darussalam.view.auth

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentVerifyEamailBinding
import com.dtech.darussalam.databinding.FragmentVerifyOtpBinding
import com.dtech.darussalam.utilities.extensions.hideKeyboard
import com.dtech.darussalam.utilities.extensions.showToastMessage
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment

class VerifyOtpFragment: BaseFragment() , View.OnClickListener, TextWatcher, View.OnKeyListener , View.OnFocusChangeListener{

    lateinit var binding: FragmentVerifyOtpBinding
    private var countDownTimer: CountDownTimer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_verify_otp , container , false)
        setListener()
        startTimer()
        return binding.root
    }

    private fun setListener(){
        binding.tvResendCode.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
        binding.et1.addTextChangedListener(this)
        binding.et2.addTextChangedListener(this)
        binding.et3.addTextChangedListener(this)
        binding.et4.addTextChangedListener(this)
        binding.et1.setOnKeyListener(this)
        binding.et2.setOnKeyListener(this)
        binding.et3.setOnKeyListener(this)
        binding.et4.setOnKeyListener(this)
        binding.et1.onFocusChangeListener = this
        binding.et2.onFocusChangeListener = this
        binding.et3.onFocusChangeListener = this
        binding.et4.onFocusChangeListener = this
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tvResendCode ->{
                binding.tvResendCode.isVisible = false
                startTimer()
            }
            R.id.btnSubmit ->{
                if (validateInput()){
                    addFragment(R.id.authContainer , UpdatePasswordFragment() , "UpdatePasswordFragment")
                }
            }
        }

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(p0: Editable?) {
        if (binding.et1.hasFocus()) {
            if (binding.et1.text.toString().length == 1) {
                binding.et1.clearFocus()
                binding.et2.requestFocus()
            }
        } else if (binding.et2.hasFocus()) {
            if (binding.et2.text.toString().length == 1) {
                binding.et2.clearFocus()
                binding.et3.requestFocus()
            }

        } else if (binding.et3.hasFocus()) {
            if (binding.et3.text.toString().length == 1) {
                binding.et3.clearFocus()
                binding.et4.requestFocus()
            }

        } else if (binding.et4.hasFocus()) {
            if (binding.et4.text.toString().length == 1) {
                binding.et1.clearFocus()
                binding.et2.clearFocus()
                binding.et3.clearFocus()
                binding.et4.clearFocus()
                binding.root.hideKeyboard()
            /*    if (validateInput()) {
                    callVerifyOtp()
                }*/
            }
        }
    }

    override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DEL)
            when (v!!.id) {
                R.id.et1 -> {

                }
                R.id.et2 -> {
                    if (TextUtils.isEmpty(binding.et2.text.toString())) {
                        binding.et2.clearFocus()
                        binding.et1.requestFocus()
                    } else {
                        binding.et2.setText("")
                    }
                }
                R.id.et3 -> {
                    if (TextUtils.isEmpty(binding.et3.text.toString())) {
                        binding.et3.clearFocus()
                        binding.et2.requestFocus()
                    } else {
                        binding.et3.setText("")
                    }
                }
                R.id.et4 -> {
                    if (TextUtils.isEmpty(binding.et4.text.toString())) {
                        binding.et4.clearFocus()
                        binding.et3.requestFocus()
                    } else {
                        binding.et4.setText("")
                    }
                }
            }

        return false
    }
    private fun startTimer() {
        countDownTimer = object : CountDownTimer((30 * 1 * 1000).toLong(), 100) {
            override fun onTick(l: Long) {
                val seconds = l / 1000
                val currentMinute = seconds / 60
                binding.tvTimer.text = String.format("%02d", seconds / 60) + ":" + String.format("%02d", seconds % 60)
                if (currentMinute == 0L && seconds == 0L) {
                    binding.tvResendCode.visibility = View.VISIBLE
                    binding.tvTimer.text = "00:00"
                    if (countDownTimer != null) {
                        countDownTimer!!.cancel()
                    }
                } else {

                }
            }

            override fun onFinish() {
                binding.tvResendCode.visibility = View.VISIBLE
                binding.tvTimer.text = "00:00"
                if (countDownTimer != null) {
                    countDownTimer!!.cancel()
                }
            }

        }.start()
    }

    private fun validateInput() : Boolean{
        if (binding.et1.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.et1.requestFocus()
            return false
        } else   if (binding.et2.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.et2.requestFocus()
            return false
        }else   if (binding.et3.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.et3.requestFocus()
            return false
        }else   if (binding.et4.text.toString().isEmpty()){
            ActivityBase.activity.showToastMessage(getString(R.string.this_field_is_required))
            binding.et4.requestFocus()
            return false
        }
        return true
    }
}