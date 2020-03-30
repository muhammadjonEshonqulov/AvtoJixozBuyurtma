package com.example.avtojihozbuyurtma.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.models.OrderData
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTools( tool: List<JixozData>): Completable

    @Query("select * from `JixozData`")
    fun getAllTools(): Observable<List<JixozData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrder(order: OrderData): Completable

    @Query("select * from `OrderData`")
    fun getAllOrders(): Observable<List<OrderData>>

}