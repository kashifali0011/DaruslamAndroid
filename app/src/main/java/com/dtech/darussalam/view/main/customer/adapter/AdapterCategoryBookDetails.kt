package com.dtech.darussalam.view.main.customer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.AdapterCatagoriesBooksBinding
import com.dtech.darussalam.databinding.AdapterCatagoriesBooksDetailsBinding

class AdapterCategoryBookDetails(val context: Context, /*var mListener: OnClickListener?*/) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: AdapterCatagoriesBooksDetailsBinding = AdapterCatagoriesBooksDetailsBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.adapter_catagories_books_details , parent , false))

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var mHolder = holder as ViewHolder

      /*  mHolder.binding.clRoot.setOnClickListener {
            mListener?.selectCategories()
        }*/



    }

    override fun getItemCount(): Int {
        return  10
    }

    class ViewHolder(var binding: AdapterCatagoriesBooksDetailsBinding):
            RecyclerView.ViewHolder(binding.root)

    interface OnClickListener{
        fun selectCategories()
    }
}