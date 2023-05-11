package com.dtech.darussalam.view.tour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentTourThreeBinding
import com.dtech.darussalam.view.base.BaseFragment

class TourThreeFragment : BaseFragment() {

    lateinit var binding: FragmentTourThreeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_tour_three , container , false)


        return binding.root
    }
}