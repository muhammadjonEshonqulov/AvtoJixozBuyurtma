package com.example.avtojihozbuyurtma.utils

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import uz.mahmudxon.library.ui.BaseFragment
import uz.mahmudxon.library.util.startFragment
import java.text.SimpleDateFormat
import java.util.*

fun BaseFragment.replaceAllFragments(fragment: BaseFragment) {
    activity!!.supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    (activity!! as AppCompatActivity).startFragment(fragment)
}


@SuppressLint("NewApi", "ObsoleteSdkInt")
fun String.decode(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {

        android.util.Base64.decode(this, android.util.Base64.DEFAULT)
            .toString(charset("UTF-8"))
    } else {
        TODO("VERSION.SDK_INT < FROYO")
    }
}


fun String.getTime() = this.split(" ")[1].substring(0, 5)

fun Int.getDuration(): String {
    val a = this / 3600
    val b = this / 60
    val h = if (a <= 9) "0$a" else (a).toString()
    val m = if (b <= 9) "0${b}" else (b).toString()
    return "$h:$m"
}

@SuppressLint("SimpleDateFormat")
fun Int.getDate(): String {
    val c: Calendar = GregorianCalendar()
    c.time = Date()
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    c.add(Calendar.MONTH, -this)
    return sdf.format(c.time)
}


fun EditText.showKeyboard() {
    post {
        requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}
