package com.dtech.darussalam.view.main.customer.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dtech.darussalam.R
import com.dtech.darussalam.databinding.AdapterBookCategoriesBinding

class AdapterBookCategoriesName(val context: Context , var homeOrCategory : Boolean) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: AdapterBookCategoriesBinding = AdapterBookCategoriesBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.adapter_book_categories , parent , false))

        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var mHolder = holder as ViewHolder
        if (position == 0){
            mHolder.binding.rlBookName.setBackgroundResource(R.drawable.ic_round_croner_blue_gradiant)
            mHolder.binding.tvBookName.setTextColor(Color.parseColor("#FFFFFF"))
        }else{

            if (homeOrCategory){
            mHolder.binding.rlBookName.setBackgroundResource(R.drawable.ic_white_design_no_corner)
            mHolder.binding.tvBookName.setTextColor(Color.parseColor("#000000"))
        }else{
                mHolder.binding.rlBookName.setBackgroundResource(R.drawable.ic_background_catagory)
                mHolder.binding.tvBookName.setTextColor(Color.parseColor("#000000"))
            }

        }
    }

    override fun getItemCount(): Int {
        return  10
    }

    class ViewHolder(var binding: AdapterBookCategoriesBinding):
            RecyclerView.ViewHolder(binding.root)
}