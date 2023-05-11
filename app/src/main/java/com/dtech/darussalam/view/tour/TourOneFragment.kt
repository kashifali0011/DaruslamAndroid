package com.dtech.darussalam.view.tour

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.airbnb.lottie.LottieDrawable
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.FragmentTourOneBinding
import com.dtech.darussalam.view.base.BaseFragment

class TourOneFragment : BaseFragment(){
    lateinit var binding: FragmentTourOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_tour_one , container , false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }
}