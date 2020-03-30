package com.example.avtojihozbuyurtma.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.main.presenter.MainPresenter
import com.example.avtojihozbuyurtma.ui.about.view.AboutFragment
import com.example.avtojihozbuyurtma.ui.katalog.view.KatalogFragment
import com.example.avtojihozbuyurtma.ui.orders.view.OrdersFragment
import kotlinx.android.synthetic.main.fragment_main.*
import uz.mahmudxon.library.ui.BaseFragment
import java.util.*

class MainFragment : BaseFragment(R.layout.fragment_main,  false), MainView {

    lateinit var presenter: MainPresenter

    override fun onCreatedView(senderData: Any?) {
        activity?.title = "Avto Jixozlar"

        Objects.requireNonNull(Objects.requireNonNull(activity) as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(false)
        presenter = MainPresenter(this, Repository(requireContext()))

//        presenter.login("user name", "password")
        btn1?.setOnClickListener {
            startFragment(KatalogFragment(), isAnimate = true)
        }
        btn2?.setOnClickListener {
            startFragment(OrdersFragment(), isAnimate = true)
        }
        btn3?.setOnClickListener {
            startFragment(AboutFragment(), isAnimate = true)
        }
        btn4?.setOnClickListener {
            activity?.finish()
        }
    }

    override fun showError(error: Int) {

    }


}



