package com.example.avtojihozbuyurtma.ui.katalog.view

import android.view.View
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.ui.base.SingleTypeAdapter
import kotlinx.android.synthetic.main.item_jixoz.view.*

class KatalogAdapter : SingleTypeAdapter<JixozData>(R.layout.item_jixoz, ArrayList()) {
    var onItemClick: ((JixozData) -> Unit)? = null

    override fun bindData(itemView: View, position: Int) {
        itemView.cardView?.setOnClickListener {
            onItemClick?.invoke(data[position])
        }
        itemView.image?.setImageResource(data[position].rasm)
        itemView.text?.text =
            data[position].mashina_turi + "  " + data[position].extiyod_qism + "   " + data[position].narx.toString()
    }

}