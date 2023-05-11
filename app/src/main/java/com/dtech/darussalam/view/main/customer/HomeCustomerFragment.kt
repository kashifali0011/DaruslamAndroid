package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentCustomerHomeBinding
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.customer.adapter.AdapterBestSellers
import com.dtech.darussalam.view.main.customer.adapter.AdapterBookCategoriesName
import com.dtech.darussalam.view.main.customer.adapter.AdapterBookCategory
import com.dtech.darussalam.view.main.customer.adapter.AdapterHomeSlider

class HomeCustomerFragment: BaseFragment() , View.OnClickListener , AdapterBookCategory.OnClickListener {

    lateinit var binding: FragmentCustomerHomeBinding
    private var bookAdapter: AdapterBookCategoriesName? = null
    private var adapterBookCategory: AdapterBookCategory? = null
    private var adapterBestSellers: AdapterBestSellers? = null
    private var adapterHomeSlider: AdapterHomeSlider? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_customer_home , container , false)
        setListener()
        setUiObserver()
        getSlider()
        getBookCategoriesName()
        getCategoriesBook()
        getBestSeller()
        return binding.root
    }

    private fun setUiObserver(){

    }

    private fun setListener(){
        binding.tvSeeAll.setOnClickListener(this)
        binding.rlBasket.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tvSeeAll ->{
                addFragment(R.id.mainContainer , BestSellersFragment() , "BestSellersFragment")
            }
            R.id.rlBasket ->{
                addFragment(R.id.mainContainer , MyCartFragment() , "MyCartFragment")
            }

        }
    }

    private fun getSlider(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvSlider.layoutManager = categoryLayoutManager
        adapterHomeSlider = AdapterHomeSlider(requireActivity())
        binding.rvSlider.adapter = adapterHomeSlider
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvSlider)
    }

    private fun getBookCategoriesName(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvBookCategoriesName.layoutManager = categoryLayoutManager
        bookAdapter = AdapterBookCategoriesName(requireActivity() , true)
        binding.rvBookCategoriesName.adapter = bookAdapter
    }
    private fun getCategoriesBook(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvBookCategory.layoutManager = categoryLayoutManager
        adapterBookCategory = AdapterBookCategory(requireActivity() , this)
        binding.rvBookCategory.adapter = adapterBookCategory
    }
    private fun getBestSeller(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvBestSeller.layoutManager = categoryLayoutManager
        adapterBestSellers = AdapterBestSellers(requireActivity())
        binding.rvBestSeller.adapter = adapterBestSellers
    }

    override fun selectCategories() {
        addFragment(R.id.mainContainer , CategoriesBookDetailsFragment() , "CategoriesBookDetailsFragment")
    }
}