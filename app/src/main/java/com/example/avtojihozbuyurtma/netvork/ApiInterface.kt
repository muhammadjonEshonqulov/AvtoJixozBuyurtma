package com.example.avtojihozbuyurtma.netvork

import com.example.avtojihozbuyurtma.models.JixozData
import com.example.avtojihozbuyurtma.models.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("")
    fun login(@Query("login") login: String, @Query("parol") parol: String): Observable<LoginResponse>


    @GET("")
    fun getAllTools(): Observable<List<JixozData>>
}