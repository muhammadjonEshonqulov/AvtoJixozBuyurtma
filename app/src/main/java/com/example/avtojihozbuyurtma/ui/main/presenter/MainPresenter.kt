package com.example.avtojihozbuyurtma.ui.main.presenter

import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.database.MyDao
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.main.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import com.example.avtojihozbuyurtma.utils.Error

class MainPresenter(val view: MainView, val repository: Repository) {

    private var dao: MyDao? = null
    lateinit var compositeDisposable: CompositeDisposable
    lateinit var data: ArrayList<JixozData>

    init {
        loadData()
    }

//    fun login(username: String, password: String) {
//        compositeDisposable = CompositeDisposable()
//        compositeDisposable.add(
//            repository.login(username, password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    getAllTools()
//                }, {
//                    view.showError(Error.CONNECTION_ERROR)
//                })
//        )
//    }

//    fun getAllTools() {
//        compositeDisposable.add(
//            repository.getAllTools()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    data = ArrayList()
//                    data.addAll(it)
//                    saveAllTools(data)
//                }, {
//                    view.showError(Error.ANOTHER_ERROR)
//                })
//        )
//    }

    fun saveAllTools(tools: ArrayList<JixozData>) {
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            repository.saveTools(tools.toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    view.showError(Error.ANOTHER_ERROR)
                })
        )
    }

    fun loadData() {
        data = ArrayList()
        data.add(
            JixozData(
                0,
                "Cobalt",
                "Akkumulator Atlanta",
                "390 000 so'm",
                "2",
                R.drawable.akkumulator_atlant
            )
        )
        data.add(
            JixozData(
                1,
                "Cobalt",
                "Akkumulator Delkor",
                "470 000 so'm",
                "3",
                R.drawable.akkumulator_delkor
            )
        )
        data.add(JixozData(2, "Anatomiy", "Ruli", "145 dollar", "4", R.drawable.anatomy_ruli))
        data.add(
            JixozData(
                3,
                "Cobalt",
                "Amortizator",
                "800 000 so'm",
                "2",
                R.drawable.cobalt_amortizator
            )
        )
        data.add(
            JixozData(
                4,
                "Lasette ",
                "Datchik Tezlik",
                "5 dollar",
                "3",
                R.drawable.datchik_skotost_lasette
            )
        )
        data.add(
            JixozData(
                5,
                "Gentra ",
                "Orqa fara",
                "950 000 so'm",
                "4",
                R.drawable.gentra_orqa_fara
            )
        )
        data.add(JixozData(6, "Gentra ", "tablo", "180 dollar", "5", R.drawable.gentra_tablo))
        data.add(
            JixozData(
                7,
                "Gentra ",
                "Damkran",
                "950 000 so'm",
                "6",
                R.drawable.lacetti_gentra_domkran
            )
        )
        data.add(
            JixozData(
                8,
                "Lasettte ",
                "cruze old fara",
                "400 dollar",
                "7",
                R.drawable.lasette_cruze_old_fara
            )
        )
        data.add(
            JixozData(
                9,
                "Lasettte ",
                "Orqa fara",
                "130 000 so'm",
                "8",
                R.drawable.lasette_orqa_fara
            )
        )
        data.add(
            JixozData(
                10,
                "Lasettte ",
                "Orqa oynasi",
                "200 000 so'm",
                "5",
                R.drawable.lasette_orqa_oynasijpg
            )
        )
        data.add(
            JixozData(
                11,
                "Lasettte ",
                "mator remen",
                "20 dollar",
                "7",
                R.drawable.lasette_remen_generator
            )
        )
        data.add(JixozData(12, "Lasettte ", " fara", "840 000 so'm", "3", R.drawable.lasettefara))
        data.add(JixozData(13, "Matiz ", " eshik", "250 000 so'm", "4", R.drawable.matiz_eshik))
        data.add(JixozData(14, "Matiz ", " fara", "150 000 so'm", "6", R.drawable.matiz_fara))
        data.add(
            JixozData(
                15,
                "Nexia ",
                " compressor",
                "770 000 so'm",
                "5",
                R.drawable.nexia_compressor
            )
        )
        data.add(JixozData(16, "Nexia ", " fara", "130 000 so'm", "3", R.drawable.nexia_fara))
        data.add(
            JixozData(
                17,
                "westa  ",
                "akkumlator",
                "360 000 so'm",
                "7",
                R.drawable.westa_akkumlator
            )
        )

        saveAllTools(data)
    }

}