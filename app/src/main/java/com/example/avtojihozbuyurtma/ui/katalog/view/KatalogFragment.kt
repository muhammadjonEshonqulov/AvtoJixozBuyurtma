package com.example.avtojihozbuyurtma.ui.katalog.view

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.katalog.presenter.KatalogPresenter
import com.example.avtojihozbuyurtma.ui.katalogInfo.view.KatalogInfoFragment
import kotlinx.android.synthetic.main.fragment_katalog.*
import uz.mahmudxon.library.ui.BaseFragment
import uz.mahmudxon.library.util.toast
import java.util.*
import kotlin.collections.ArrayList


class KatalogFragment : BaseFragment(R.layout.fragment_katalog,false), KatalogView {

    lateinit var adapter: KatalogAdapter
    private lateinit var data: ArrayList<JixozData>
    lateinit var presenter: KatalogPresenter

    override fun onCreatedView(senderData: Any?) {
        activity?.title = "Kataloglar"

        Objects.requireNonNull(Objects.requireNonNull(activity) as AppCompatActivity)
            .supportActionBar?.setDisplayHomeAsUpEnabled(true)
        presenter = KatalogPresenter(this, Repository(requireContext()))
        presenter.getAllTolls()
    }

    override fun showError(error: String) {
        toast("$error")
    }

    override fun showlist(data: ArrayList<JixozData>) {
        adapter = KatalogAdapter()
        list?.adapter = adapter
        list?.layoutManager = LinearLayoutManager(requireContext())
        adapter.swapdata(data)
        adapter.onItemClick = {
            startFragment(KatalogInfoFragment(), it, isAnimate = true)
        }
    }


}
