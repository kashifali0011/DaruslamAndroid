package com.dtech.darussalam.view.main.customer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentFavoritesBinding
import com.dtech.darussalam.view.base.BaseFragment
import com.dtech.darussalam.view.main.customer.adapter.AdapterCategoryBookDetails

class FavouritesFragment: BaseFragment() , View.OnClickListener{

    lateinit var binding: FragmentFavoritesBinding
    private var adapterCategoryBookDetails: AdapterCategoryBookDetails? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_favorites , container , false)
        setListener()
        getFavourites()
        return binding.root
    }
    private fun setListener(){

    }

    override fun onClick(v: View?) {
        when(v!!.id){

        }

    }
    private fun getFavourites(){
        val numberOfColumns = 2
        binding.rvBookCategoryDetails.setLayoutManager(GridLayoutManager(requireActivity(), numberOfColumns))
        adapterCategoryBookDetails = AdapterCategoryBookDetails(requireActivity())
        binding.rvBookCategoryDetails.adapter = adapterCategoryBookDetails
    }
}