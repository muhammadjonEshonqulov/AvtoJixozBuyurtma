package com.example.avtojihozbuyurtma.ui.katalogInfo.view

import android.annotation.SuppressLint
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.ui.registratsion.view.RegistrationFragment
import kotlinx.android.synthetic.main.fragment_katalog_info.*
import uz.mahmudxon.library.ui.BaseFragment

class KatalogInfoFragment() : BaseFragment(R.layout.fragment_katalog_info,false) {

    @SuppressLint("SetTextI18n")
    override fun onCreatedView(senderData: Any?) {
        val jixozData: JixozData = senderData as JixozData
        activity?.title = "Tovar haqida"

        rasm_?.setImageResource(jixozData.rasm)
        mashina_turi_?.text = jixozData.mashina_turi
        extiyod_qism_?.text = jixozData.extiyod_qism
        narxi_?.text = jixozData.narx
        yetkazish_kuni_?.text = jixozData.yetkazish_kuni + " soat"

        buy?.setOnClickListener {
            startFragment(RegistrationFragment(), jixozData, true)

        }
    }


}