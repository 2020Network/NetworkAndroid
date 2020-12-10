package com.example.studygorup.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper{



    private var retrofit = Retrofit.Builder()
        .baseUrl("https://eb6883b804ca.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserAPI() : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }

    fun getGroupAPI() : GroupAPI{
        return retrofit.create(GroupAPI::class.java)
    }
}