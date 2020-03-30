package com.example.avtojihozbuyurtma.ui.orders.view

import android.annotation.SuppressLint
import android.view.View
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.OrderData
import com.example.avtojihozbuyurtma.ui.base.SingleTypeAdapter
import kotlinx.android.synthetic.main.item_buyurtna.view.*

class OrderAdapter : SingleTypeAdapter<OrderData>(R.layout.item_buyurtna, ArrayList()) {

    @SuppressLint("SetTextI18n")
    override fun bindData(itemView: View, position: Int) {
        itemView.image_order?.setImageResource(data[position].rasm)
        itemView.text_order?.text =
            "${position + 1}.Buyurtmachi malumotlari:\nFamiliyasi : " + data[position].fam + "\nIsmi : " + data[position].ism + "\nTel nomer:" +
                    data[position].tel_nomer + "\nBuyurtma ma'lumotlari:\nMashina turi:" + data[position].mashina_turi +
                    "\nExtiyod qism:" + data[position].extiyod_qism + "\nNarxi:" + data[position].narx + "\nYetkazib berish vaqti:" +
                    data[position].yetkazish_kuni + " kun\nTo'lov turi:" + data[position].tolov_turi + "\nTo'langanligi:" + data[position].tolanganligi
    }
}