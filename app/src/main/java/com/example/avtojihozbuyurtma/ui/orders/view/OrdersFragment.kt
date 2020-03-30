package com.example.avtojihozbuyurtma.ui.orders.view

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.OrderData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.orders.presenter.OrdersPresenter
import kotlinx.android.synthetic.main.fragment_orders.*
import uz.mahmudxon.library.ui.BaseFragment
import java.util.*
import kotlin.collections.ArrayList


class OrdersFragment : BaseFragment(R.layout.fragment_orders, false), OrdersView {
    lateinit var presenter: OrdersPresenter
    lateinit var adapter: OrderAdapter

    override fun onCreatedView(senderData: Any?) {
        activity?.title = "Buyurtmalar ro'yxati"
        Objects.requireNonNull(Objects.requireNonNull(activity) as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter = OrdersPresenter(this, Repository(requireContext()))
        presenter.getAllOrders()

    }

    override fun showOrders(data: ArrayList<OrderData>) {
        text_null?.visibility = View.GONE
        adapter = OrderAdapter()
        list_orders?.adapter = adapter
        list_orders?.layoutManager = LinearLayoutManager(requireContext())
        adapter.swapdata(data)

    }

}