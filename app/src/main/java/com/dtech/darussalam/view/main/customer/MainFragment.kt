package com.dtech.darussalam.view.main.customer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentMainHomeBinding
import com.dtech.darussalam.utilities.enums.HomeBottomSheetEnums
import com.dtech.darussalam.utilities.helper.VPDashBoardAdapter
import com.dtech.darussalam.view.base.ActivityBase
import com.dtech.darussalam.view.base.BaseFragment

class MainFragment: BaseFragment() , View.OnClickListener{

    lateinit var binding: FragmentMainHomeBinding
    lateinit var adapter: VPDashBoardAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_main_home , container , false)
        binding.selection = HomeBottomSheetEnums.HOME.value
        setListener()
        setupViewPager()

        return binding.root
    }
    private fun setListener(){
        binding.clHome.setOnClickListener(this)
        binding.clFavourites.setOnClickListener(this)
        binding.clMore.setOnClickListener(this)

    }

    private fun setupViewPager() {
        adapter = VPDashBoardAdapter(childFragmentManager)
        adapter.addFragment(HomeCustomerFragment(), "HomeCustomerFragment")
        adapter.addFragment(FavouritesFragment(), "FavouritesFragment")
        adapter.addFragment(MoreFragment(), "MoreFragment")
        binding.vpMain.adapter = adapter

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.clHome ->{
                binding.selection = HomeBottomSheetEnums.HOME.value
                binding.vpMain.setCurrentItem(0, true)
            }
            R.id.clFavourites ->{
                binding.selection = HomeBottomSheetEnums.FAVORITES.value
                binding.vpMain.setCurrentItem(1, true)
            }
            R.id.clMore ->{
                binding.selection = HomeBottomSheetEnums.MORE.value
                binding.vpMain.setCurrentItem(2, true)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (val fragment = adapter.getItem(binding.vpMain.currentItem)) {
            is MoreFragment -> {
                fragment.onActivityResult(requestCode, resultCode, data)
            }

            else -> {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }

    }
}