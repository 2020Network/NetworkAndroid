package com.example.mvvmproject.netwrok.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper{



    private var retrofit = Retrofit.Builder()
        .baseUrl("https://ae3206c50e57.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserAPI() : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }

    fun getGroupAPI() : GroupAPI{
        return retrofit.create(GroupAPI::class.java)
    }
}