package com.dtech.darussalam.view.main.customer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.AdapterSliderBinding

class AdapterHomeSlider(val context: Context) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: AdapterSliderBinding = AdapterSliderBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.adapter_slider , parent , false))

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return  10
    }

    class ViewHolder(var binding: AdapterSliderBinding):
            RecyclerView.ViewHolder(binding.root)
}