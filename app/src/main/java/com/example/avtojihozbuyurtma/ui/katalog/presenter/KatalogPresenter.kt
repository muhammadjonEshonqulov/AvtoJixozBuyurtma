package com.example.avtojihozbuyurtma.ui.katalog.presenter

import android.util.Log
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.katalog.view.KatalogView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class KatalogPresenter(val view: KatalogView, val repository: Repository) {

    lateinit var compositeDisposable: CompositeDisposable
    fun getAllTolls() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.getTools()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val data: ArrayList<JixozData> = ArrayList()
                    data.addAll(it)
                    Log.i("TTT","size :: ${data.size}")
                    view.showlist(data)
                }, {
                    view.showError(it.toString())
                })
        )
    }



}