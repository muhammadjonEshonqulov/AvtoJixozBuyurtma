package com.example.avtojihozbuyurtma.ui.payment.presenter

import com.example.avtojihozbuyurtma.models.OrderData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.payment.view.PaymentView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PaymentPresenter(val view: PaymentView, val repository: Repository) {

    lateinit var compositeDisposable: CompositeDisposable

    fun tolov(orderData: OrderData, typePayment: Int) {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.saveOrder(orderData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //                    view.showDialog(getAllOrdersForFindCount(typePayment).toInt() + 1, typePayment)
                    getAllOrdersForFindCount(typePayment)
                }, {})
        )
    }

    fun getAllOrdersForFindCount(typePayment: Int) {
        val data: ArrayList<OrderData> = ArrayList()
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getOrders()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    data.addAll(it)
                    view.showDialog(data.size, typePayment)
                }, {})
        )

    }
}