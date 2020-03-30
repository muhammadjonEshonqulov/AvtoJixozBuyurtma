package com.example.avtojihozbuyurtma.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderData(
    @PrimaryKey
    var fam: String,
    var ism: String,
    var tel_nomer: String,
    var mashina_turi: String,
    var extiyod_qism: String,
    var narx: String,
    var yetkazish_kuni: String,
    var rasm: Int,
    var tolanganligi: String,
    var tolov_turi: String
)