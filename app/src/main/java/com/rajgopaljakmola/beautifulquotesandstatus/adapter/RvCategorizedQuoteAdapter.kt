package com.rajgopaljakmola.beautifulquotesandstatus.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rajgopaljakmola.beautifulquotesandstatus.databinding.CategorizedQuoteBarBinding
import com.rajgopaljakmola.beautifulquotesandstatus.model.RvCategorizedQuoteModel

class RvCategorizedQuoteAdapter(var dataList: ArrayList<RvCategorizedQuoteModel>, var context: Context): RecyclerView.Adapter<RvCategorizedQuoteAdapter.MyViewHolder>() {
    inner class MyViewHolder(var binding:CategorizedQuoteBarBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = CategorizedQuoteBarBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvSpecificQuote.text = dataList.get(position).quote
        holder.binding.tvAuthor.text = dataList.get(position).author
        val text = dataList.get(position).quote + "\n - " + dataList.get(position).author
        holder.binding.clipboard.setOnClickListener {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            // Check if the device supports vibration
            if (vibrator.hasVibrator()) {
                // Vibrate for 100 milliseconds
                vibrator.vibrate(100)
            }
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copied Text", text)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
        }
        holder.binding.share.setOnClickListener {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            // Check if the device supports vibration
            if (vibrator.hasVibrator()) {
                // Vibrate for 100 milliseconds
                vibrator.vibrate(100)
            }
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            val shareBody = text
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
            context.startActivity(Intent.createChooser(sharingIntent, "Share via"))

        }
    }
}