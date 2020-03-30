package com.example.avtojihozbuyurtma.repository

import android.content.Context
import com.example.avtojihozbuyurtma.database.MyDatabase
import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.models.OrderData
import com.example.avtojihozbuyurtma.netvork.ApiClient
import com.example.avtojihozbuyurtma.netvork.ApiInterface
import com.example.avtojihozbuyurtma.database.MyDao as MyDao

class Repository (context: Context) {

    var dao: MyDao

    init {
        MyDatabase.initDatabase(context)
        dao = MyDatabase.getDatabase().dao()
    }

//    companion object {
//        fun getRepositoryWithApiClient(
//            context: Context,
//            invalidateApiClient: Boolean = false
//        ): Repository {
//            MyDatabase.initDatabase(context)
//            if (invalidateApiClient) ApiClient.inalidate()
//
//            return Repository(ApiClient.instanse(context).create(ApiInterface::class.java), context)
//        }
//    }
//
//    fun login(username: String, password: String) = apiIterface.login(username, password)
//    fun getAllTools() = apiIterface.getAllTools()

    fun saveTools(tools: List<JixozData>) = dao.insertAllTools(tools)
    fun getTools() = dao.getAllTools()
    fun saveOrder(orderData: OrderData) = dao.insertOrder(orderData)
    fun getOrders() = dao.getAllOrders()
}