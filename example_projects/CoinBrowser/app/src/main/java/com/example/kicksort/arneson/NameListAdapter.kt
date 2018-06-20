package com.example.kicksort.arneson

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.name_list_item.view.*

/**
 * Created by kicksort on 2017-12-22.
 */

class NameListAdapter(private val currencies: List<Currency>) : RecyclerView.Adapter<NameListAdapter.NameHolder>()  {
    override fun onBindViewHolder(holder: NameHolder, position: Int) {
        var currency = currencies[position]
        holder.setName(currency.name)
        holder.setImage("https://www.cryptocompare.com" + currency.imageUrl)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameHolder {
        var listItem = parent.inflate(R.layout.name_list_item, false)

        return NameHolder(listItem)
    }


    class NameHolder (v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        private var textView: TextView
        private var imageView: ImageView

        init {
            textView = v.name_text
            imageView = v.coin_image

        }

        fun setName(name: String) {
            textView.text = name
        }

        fun setImage(imageUrl: String) {
            Glide.with(view.context).load(imageUrl).into(imageView)
        }
    }
}

