package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentCategoriesBinding
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.customer.adapter.AdapterBookCategoriesName
import com.dtech.darussalam.view.main.customer.adapter.AdapterCategoryBookDetails

class CategoriesBookDetailsFragment: BaseFragment(),  View.OnClickListener {

    lateinit var binding: FragmentCategoriesBinding
    private var bookAdapter: AdapterBookCategoriesName? = null
    private var adapterCategoryBookDetails: AdapterCategoryBookDetails? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_categories , container , false)
        setListener()
        getBookCategoriesName()
        getBookCategoriesDetails()

        return binding.root
    }
    private fun setListener(){

    }

    override fun onClick(v: View?) {
        when(v!!.id){

        }
    }
    private fun getBookCategoriesName(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
        binding.rvBookCategoriesName.layoutManager = categoryLayoutManager
        bookAdapter = AdapterBookCategoriesName(requireActivity() , false)
        binding.rvBookCategoriesName.adapter = bookAdapter
    }

    private fun getBookCategoriesDetails(){
        val numberOfColumns = 2
        binding.rvBookCategoryDetails.setLayoutManager(GridLayoutManager(requireActivity(), numberOfColumns))
        adapterCategoryBookDetails = AdapterCategoryBookDetails(requireActivity())
        binding.rvBookCategoryDetails.adapter = adapterCategoryBookDetails

    }

}