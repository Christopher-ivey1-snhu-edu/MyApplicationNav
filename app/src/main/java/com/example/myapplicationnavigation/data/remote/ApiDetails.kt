package com.example.myapplicationnavigation.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.transform.OutputKeys


object ApiDetails {
    // Object -> Singleton and can be accessed everywhere

    //https://61e947967bc0550017bc61bf.mockapi.io/api/v1/people
    //https://61e947967bc0550017bc61bf.mockapi.io/api/v1/rooms
    //Base URL
    //END point
    val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/"
    const val END_POINT_PEOPLE = "v1/people"
    const val END_POINT_ROOM = "v1/rooms"

    //Retrofit Instance)
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder().apply {
                this.addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }.build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Service reference for making the API call
    val service = retrofit.create(ApiService::class.java)

}