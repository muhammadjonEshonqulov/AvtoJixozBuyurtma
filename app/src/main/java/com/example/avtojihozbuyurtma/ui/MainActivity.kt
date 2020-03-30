package com.example.avtojihozbuyurtma.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.avtojihozbuyurtma.R
import com.example.avtojihozbuyurtma.ui.main.view.MainFragment

class MainActivity : AppCompatActivity() {

    private var mes: String = ""
    private var fragment = Fragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replace(MainFragment())
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
            super.onBackPressed()
        return true
    }

    fun replace(fragment: Fragment) {
        this.fragment = fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.commit()
    }
}
