package com.example.avtojihozbuyurtma.ui.orders.presenter

import com.example.avtojihozbuyurtma.models.OrderData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.orders.view.OrdersView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class OrdersPresenter(val view: OrdersView, val repository: Repository) {

    lateinit var compositeDisposable: CompositeDisposable

    fun getAllOrders() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getOrders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val data: ArrayList<OrderData> = ArrayList()
                    data.addAll(it)
                    if(data.isNotEmpty()){
                        view.showOrders(data)
                    }
                }, {})
        )
    }

}