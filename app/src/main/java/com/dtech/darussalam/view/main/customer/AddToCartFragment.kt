package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentAddToCartBinding
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.customer.adapter.AdapterBookCategory
import com.dtech.darussalam.view.main.customer.adapter.AdapterMyLikeBook
import com.dtech.darussalam.view.main.customer.adapter.AdapterSelectBook

class AddToCartFragment : BaseFragment(), View.OnClickListener , AdapterSelectBook.OnClickListener , AdapterMyLikeBook.OnClickListener {
    lateinit var binding: FragmentAddToCartBinding
    private var adapterSelectBook : AdapterSelectBook? = null
    private var adapterBookCategory: AdapterMyLikeBook? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_to_cart, container, false)

        setListener()
        getSelectBook()
        getCategoriesBook()
        return binding.root
    }

    private fun setListener() {
        binding.clReadMore.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.clReadMore ->{
                if (binding.showMoreAndLess.visibility == View.VISIBLE){
                    binding.showMoreAndLess.isVisible = false
                    binding.tvShowMoreOrLess.setText(R.string.read_more)
                }else{
                    binding.showMoreAndLess.isVisible = true
                    binding.tvShowMoreOrLess.setText(R.string.show_less)
                }
            }

        }
    }
    private fun getSelectBook(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL,false)
        binding.rvSelectBook.layoutManager = categoryLayoutManager
        adapterSelectBook = AdapterSelectBook(requireActivity() , this)
        binding.rvSelectBook.adapter = adapterSelectBook
    }

    private fun getCategoriesBook(){
        val categoryLayoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvBookCategory.layoutManager = categoryLayoutManager
        adapterBookCategory = AdapterMyLikeBook(requireActivity() , this)
        binding.rvBookCategory.adapter = adapterBookCategory
    }

    override fun selectBook() {

    }

    override fun selectCategories() {

    }

}