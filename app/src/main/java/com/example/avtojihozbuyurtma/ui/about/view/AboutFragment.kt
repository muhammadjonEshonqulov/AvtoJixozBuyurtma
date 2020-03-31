package com.example.avtojihozbuyurtma.ui.about.view

import androidx.appcompat.app.AppCompatActivity
import com.example.avtojihozbuyurtma.R
import uz.mahmudxon.library.ui.BaseFragment
import java.util.*

class AboutFragment : BaseFragment(R.layout.fragment_about, true) {

    override fun onCreatedView(senderData: Any?) {
        activity?.title = "Muallif"
        Objects.requireNonNull(Objects.requireNonNull(activity) as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}