package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentCheckOutPaymentMethodBinding
import com.dtech.darussalam.databinding.FragmentCheckOutShippingDetailsBinding
import com.dtech.darussalam.view.base.BaseFragment

class CheckOutShippingDetailsFragment: BaseFragment() , View.OnClickListener {

    lateinit var binding: FragmentCheckOutShippingDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_check_out_shipping_details , container , false)

        setListener()

        return binding.root
    }
    private fun setListener(){

        binding.btnConfirmPayment.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnConfirmPayment ->{
                addFragment(R.id.mainContainer , CheckOutPaymentMethodFragment() , "CheckOutPaymentMethodFragment")
            }

        }
    }

}