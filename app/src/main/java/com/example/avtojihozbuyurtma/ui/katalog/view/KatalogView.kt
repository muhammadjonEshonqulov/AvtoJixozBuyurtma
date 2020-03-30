package com.example.avtojihozbuyurtma.ui.katalog.view

import com.example.avtojihozbuyurtma.models.JixozData

interface KatalogView {
    fun showError(error: String)
    fun showlist(data: ArrayList<JixozData>)
}