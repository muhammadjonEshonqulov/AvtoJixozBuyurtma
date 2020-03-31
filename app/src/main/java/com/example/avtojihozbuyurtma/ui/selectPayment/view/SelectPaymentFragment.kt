package com.example.avtojihozbuyurtma.ui.selectPayment.view

import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.ui.payment.view.PaymentFragment
import kotlinx.android.synthetic.main.fragment_select_payment.*
import uz.mahmudxon.library.ui.BaseFragment
import uz.ost.centertsul.util.Prefs

class SelectPaymentFragment() : BaseFragment(R.layout.fragment_select_payment, false),
    SelectPaymentView {

    var narxi: String = ""


    override fun onCreatedView(senderData: Any?) {
        activity?.title = "To'lov turlari"

        val jixozData: JixozData = senderData as JixozData
        narxi = jixozData.narx
        pay?.text = narxi

        payme?.setOnClickListener {
            Prefs.save(requireContext(), "tolov_turi", "PAYME")
            startFragment(PaymentFragment(), jixozData, true)
        }
        click?.setOnClickListener {
            Prefs.save(requireContext(), "tolov_turi", "CLICK")
            startFragment(PaymentFragment(), jixozData, true)
        }
        naqtpul?.setOnClickListener {
            Prefs.save(requireContext(), "tolov_turi", "NAQT")
            startFragment(PaymentFragment(), jixozData, true)
        }
    }

}
