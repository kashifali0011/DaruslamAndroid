package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentBestSellerBinding
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.customer.adapter.AdapterBestSellerDetails
import com.dtech.darussalam.view.main.customer.adapter.AdapterBestSellers

class BestSellersFragment: BaseFragment() , View.OnClickListener , AdapterBestSellerDetails.OnClickListener {

    lateinit var binding: FragmentBestSellerBinding
    private var adapterCategoryBookDetails: AdapterBestSellerDetails? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_best_seller , container , false)
        setListener()
        getBookCategoriesDetails()
        return binding.root
    }
    private fun setListener(){

    }

    private fun getBookCategoriesDetails(){
        val numberOfColumns = 2
        binding.rvBookCategoryDetails.setLayoutManager(GridLayoutManager(requireActivity(), numberOfColumns))
        adapterCategoryBookDetails = AdapterBestSellerDetails(requireActivity() , this)
        binding.rvBookCategoryDetails.adapter = adapterCategoryBookDetails

    }

    override fun onClick(v: View?) {
        when(v!!.id){

        }
    }

    override fun selectItem() {
        addFragment(R.id.mainContainer , AddToCartFragment() , "AddToCartFragment")
    }


}