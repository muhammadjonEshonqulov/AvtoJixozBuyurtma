package com.example.avtojihozbuyurtma.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JixozData(
    @PrimaryKey
    var id: Long,
    var mashina_turi: String,
    var extiyod_qism: String,
    var narx: String,
    var yetkazish_kuni: String,
    var rasm: Int

)