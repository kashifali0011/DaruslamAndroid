package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentCheckOutPaymentMethodBinding
import com.dtech.darussalam.utilities.extensions.orderConfirmDialog
import com.dtech.darussalam.utilities.extensions.orderConfirmDialogClickListner
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment

class CheckOutPaymentMethodFragment: BaseFragment() , View.OnClickListener , orderConfirmDialogClickListner {

    lateinit var binding: FragmentCheckOutPaymentMethodBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_check_out_payment_method , container , false)

        setListener()

        return binding.root
    }
    private fun setListener(){
        binding.btnPayNow.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnPayNow ->{
                ActivityBase.activity.orderConfirmDialog("jobId" , this)
            }

        }
    }

    override fun OrderConfirm() {

    }

}