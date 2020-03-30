package com.example.avtojihozbuyurtma.netvork

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uz.ost.centertsul.util.Prefs
import java.util.concurrent.TimeUnit

object ApiClient {
    private const val BASE_URL = "http://"  //  base url
    val BASE_IMAGE_URL = "http://"  //  base url for images
    private var retrofit: Retrofit? = null

    private fun getClient(token: String): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor { chain ->
            val originalRequest = chain.request()
            val builder = originalRequest.newBuilder()
            builder.addHeader("Content-Type", "application/json")
            builder.addHeader("Authorization", token)
            val newRequest = builder.build()
            chain.proceed(newRequest)
        }
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .writeTimeout(10000L, TimeUnit.MILLISECONDS)
            .build()
    }

    fun instanse(context: Context): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .client(
                    getClient(
                        Prefs.get(
                            context,
                            Prefs.token,
                            ""
                        )
                    )
                )
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun inalidate() {
        retrofit = null
    }
}