package com.example.avtojihozbuyurtma.ui.orders.view

import com.example.avtojihozbuyurtma.models.OrderData

interface OrdersView {

    fun showOrders(data: ArrayList<OrderData>)
}