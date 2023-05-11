package com.dtech.darussalam.view.main.customer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.AdapterBestSellersBinding
import com.dtech.darussalam.databinding.AdapterCatagoriesBooksBinding

class AdapterBestSellers(val context: Context) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: AdapterBestSellersBinding = AdapterBestSellersBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.adapter_best_sellers , parent , false))

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return  10
    }

    class ViewHolder(var binding: AdapterBestSellersBinding):
            RecyclerView.ViewHolder(binding.root)
}