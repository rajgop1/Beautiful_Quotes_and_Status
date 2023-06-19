package com.rajgopaljakmola.beautifulquotesandstatus.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rajgopaljakmola.beautifulquotesandstatus.R
import com.rajgopaljakmola.beautifulquotesandstatus.databinding.ActivityMainBinding
import com.rajgopaljakmola.beautifulquotesandstatus.databinding.QuoteBarBinding
import com.rajgopaljakmola.beautifulquotesandstatus.model.RvQuoteHomeModel
import com.rajgopaljakmola.beautifulquotesandstatus.ui.categoryizedQuote.CategorizedQuote

class RvQuoteHomeAdapter(var dataList: ArrayList<RvQuoteHomeModel>, var context: Context): RecyclerView.Adapter<RvQuoteHomeAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding:QuoteBarBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = QuoteBarBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.ivQuote.setImageResource(dataList.get(position).img)
        holder.binding.tvQuote.text = dataList.get(position).heading
        holder.binding.root.setOnClickListener {
            val intent = Intent(context, CategorizedQuote::class.java)
            intent.putExtra("category", dataList.get(position).heading)
            context.startActivity(intent)
        }
    }
}