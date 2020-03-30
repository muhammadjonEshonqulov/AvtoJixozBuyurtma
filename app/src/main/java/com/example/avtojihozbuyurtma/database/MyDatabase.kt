package com.example.avtojihozbuyurtma.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.models.OrderData


@Database(entities = [JixozData::class, OrderData::class], version = 2)
abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): MyDao

    companion object {

        private var instance: MyDatabase? = null

        fun initDatabase(context: Context) {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "tools.db"
                    )
                    .fallbackToDestructiveMigration()
                    .build()

            }
        }

        fun getDatabase() = instance!!
    }


}