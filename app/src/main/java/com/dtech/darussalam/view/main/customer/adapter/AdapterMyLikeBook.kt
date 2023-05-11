package com.dtech.darussalam.view.main.customer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.AdapterBestSellersBinding
import com.dtech.darussalam.databinding.AdapterCatagoriesBooksBinding
import com.dtech.darussalam.databinding.AdapterMyLikeBookBinding

class AdapterMyLikeBook(val context: Context, var mListener: OnClickListener?) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: AdapterMyLikeBookBinding = AdapterMyLikeBookBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.adapter_my_like_book , parent , false))

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var mHolder = holder as ViewHolder

        mHolder.binding.cvBook.setOnClickListener {
            mListener?.selectCategories()
        }



    }

    override fun getItemCount(): Int {
        return  5
    }

    class ViewHolder(var binding: AdapterMyLikeBookBinding):
            RecyclerView.ViewHolder(binding.root)

    interface OnClickListener{
        fun selectCategories()
    }
}