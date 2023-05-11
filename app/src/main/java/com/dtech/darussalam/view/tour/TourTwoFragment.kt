package com.dtech.darussalam.view.tour

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentTourTwoBinding
import com.dtech.darussalam.view.base.BaseFragment

class TourTwoFragment :BaseFragment() {

    lateinit var binding: FragmentTourTwoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_tour_two , container , false)

        return binding.root
    }
}