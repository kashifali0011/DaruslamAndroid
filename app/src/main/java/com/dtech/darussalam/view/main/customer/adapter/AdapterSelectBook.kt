package com.dtech.darussalam.view.main.customer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.AdapterSelectBookBinding

class AdapterSelectBook(var context: Context , var mListener: OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var binding: AdapterSelectBookBinding = AdapterSelectBookBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.adapter_select_book , parent , false))

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var mHolder = holder as ViewHolder
          mHolder.binding.clRoot.setOnClickListener {
            mListener?.selectBook()
        }
    }

    override fun getItemCount(): Int {
       return 4
    }

    class ViewHolder(var binding: AdapterSelectBookBinding):
            RecyclerView.ViewHolder(binding.root)


    interface OnClickListener{
        fun selectBook()
    }
}