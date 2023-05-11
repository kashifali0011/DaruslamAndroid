package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentMyCartBinding
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.customer.adapter.AdapterMyCart

class MyCartFragment: BaseFragment() , View.OnClickListener , AdapterMyCart.OnClickListener{

    lateinit var binding: FragmentMyCartBinding
    private var adapterMyCart: AdapterMyCart? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_my_cart , container , false)
        setListener()
        getMyOrder()
        return binding.root
    }
    private fun setListener(){
        binding.cvProceedToCheckOut.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.cvProceedToCheckOut ->{
                addFragment(R.id.mainContainer , CheckOutShippingDetailsFragment() , "CheckOutShippingDetailsFragment")
            }

        }

    }
    private fun getMyOrder(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL,false)
        binding.rvMyItems.layoutManager = categoryLayoutManager
        adapterMyCart = AdapterMyCart(requireActivity() , this)
        binding.rvMyItems.adapter = adapterMyCart
    }

    override fun deleteItem() {

    }
}