package com.example.avtojihozbuyurtma.ui.payment.view

import kotlinx.android.synthetic.main.fragment_payment.*
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.models.OrderData
import com.example.avtojihozbuyurtma.repository.Repository
import com.example.avtojihozbuyurtma.ui.main.view.MainFragment
import com.example.avtojihozbuyurtma.ui.payment.presenter.PaymentPresenter
import kotlinx.android.synthetic.main.dialog_naqt_tolov.*
import uz.mahmudxon.library.ui.BaseFragment
import uz.mahmudxon.library.util.hideKeyboard
import uz.ost.centertsul.util.Prefs


class PaymentFragment() : BaseFragment(R.layout.fragment_payment, false), PaymentView {

    lateinit var presenter: PaymentPresenter

    override fun onCreatedView(senderData: Any?) {
        val jixozData: JixozData = senderData as JixozData

        when (Prefs.get(requireContext(), "tolov_turi", "")) {
            "NAQT" -> activity?.title = "NAQT"
            "PAYME" -> activity?.title = "PAYME"
            "CLICK" -> activity?.title = "CLICK"
        }
        payment_type_textView?.text = Prefs.get(requireContext(), "tolov_turi", "")

        presenter = PaymentPresenter(this, Repository(requireContext()))

        if (Prefs.get(requireContext(), "tolov_turi", "") == "NAQT") {
            presenter.tolov(getOrderData(jixozData), 2)
        } else {
            next__?.setOnClickListener {
                hideKeyboard()
                var typePayment: Int =
                    if (Prefs.get(requireContext(), "tolov_turi", "") == "PAYME") 0 else 1
                if (password_.text!!.isNotEmpty()) {
                    presenter.tolov(
                        getOrderData(jixozData),
                        typePayment

                    )
                }
            }
        }
    }

    private fun getOrderData(jixozData: JixozData): OrderData {
        return OrderData(
            Prefs.get(requireContext(), "last_name", ""),
            Prefs.get(requireContext(), "first_name", ""),
            Prefs.get(requireContext(), "tel_number", ""),
            jixozData.mashina_turi,
            jixozData.extiyod_qism,
            jixozData.narx,
            jixozData.yetkazish_kuni,
            jixozData.rasm,
            "To'lanmagan",
            "Naqt"
        )
    }

    override fun showDialog(size: Int, typePayment: Int) {

        val dialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialog_naqt_tolov, null, false)
        val dialog = AlertDialog.Builder(requireContext()).setView(dialogView).show()
        dialog.buyurtma_id?.text = "Buyurtma id : $size"

        when (typePayment) {
            0 -> {
                dialog.dialog_text?.text =
                    "Siz to'lovni PAYME orqali muvaffaqiyatli amalga oshirdingiz!\n Buyurtmangiz sizga tezda yetkazilib beriladi. Bizning xodim joylashuvingiz bo'yicha sizga aloqaga chiqadi.\nBizning telefon raqamimiz\n+998938254464"

            }
            1 -> {
                dialog.dialog_text?.text =
                    "Siz to'lovni CLICK orqali muvaffaqiyatli amalga oshirdingiz\n Buyurtmangiz sizga tezda yetkazilib beriladi. Bizning xodim joylashuvingiz bo'yicha sizga aloqaga chiqadi.\nBizning telefon raqamimiz\n+998938254464"
            }
            2 -> {
                dialog.dialog_text?.text =
                    "Buyurtmangiz ro'yxatga olindi. \nBizning xodimimiz sizga aloqaga chiqadi. Naqt pul to'lov shartlarini xodimimiz sizga tushuntiradi.\nBizning telefon raqamimiz\n+998938254464"
            }
        }

        dialog.setCancelable(false)
        dialog.ok?.setOnClickListener {
            dialog.dismiss()
            Prefs.clear(requireContext())
            closeAllFragmentsAndOpenThis(MainFragment(), true)
        }

//        val c = Calendar.getInstance()
//        @SuppressLint("SimpleDateFormat") val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
//        s = dateFormat.format(c.getTime()) + ""
    }
}