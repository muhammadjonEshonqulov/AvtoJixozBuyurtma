package com.example.avtojihozbuyurtma.ui.registratsion.view

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.ui.selectPayment.view.SelectPaymentFragment
import kotlinx.android.synthetic.main.fragment_registration.*
import uz.mahmudxon.library.ui.BaseFragment
import uz.mahmudxon.library.util.hideKeyboard
import uz.mahmudxon.library.util.toast
import uz.ost.centertsul.util.Prefs

class RegistrationFragment() : BaseFragment(R.layout.fragment_registration) {


    override fun onCreatedView(senderData: Any?) {
        activity?.title = "Ro'yxatdan o'tish"
        val jixozData: JixozData = senderData as JixozData


        next?.setOnClickListener {
            var telNumber = ""
            tel_nomer?.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s != null) {
                        toast("s")
                        telNumber = s.toString()
                    }
                }

            })
            if (last_name.text.toString().isNotEmpty() && first_name.text.toString().isNotEmpty() && tel_nomer.text.toString().isNotEmpty()) {
                Prefs.clear(requireContext())
                Log.i("TTT","tel nomer  : $telNumber")
                Prefs.save(requireContext(), "last_name", last_name.text.toString())
                Prefs.save(requireContext(), "first_name", first_name.text.toString())
                Prefs.save(requireContext(), "tel_number", tel_nomer.text.toString())
                check_phone_number?.visibility = View.INVISIBLE
                hideKeyboard()
                startFragment(SelectPaymentFragment(), jixozData, true)
            } else {
                check_phone_number?.visibility = View.VISIBLE
                toast("Bo'sh maydonlarni to'ldiring")
            }
        }

        back?.setOnClickListener {
            finish()
        }
    }

}
