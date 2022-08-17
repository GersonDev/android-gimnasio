package com.example.android_gimnasio.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getClient(): GimansioApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.103:3006/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(GimansioApi::class.java)
    }

}