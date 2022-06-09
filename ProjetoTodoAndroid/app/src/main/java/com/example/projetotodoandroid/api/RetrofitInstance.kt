package com.example.projetotodoandroid.api

import com.example.projetotodoandroid.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    private val retrofit by lazy {

        Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()



    }

    val api: ApiService by lazy {

        retrofit.create(ApiService::class.java)

    }


}