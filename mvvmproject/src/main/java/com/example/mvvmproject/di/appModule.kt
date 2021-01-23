package com.example.mvvmproject.di

import com.example.mvvmproject.netwrok.api.UserAPI
import com.example.mvvmproject.viewmodel.LoginViewModel
import com.example.mvvmproject.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://189893f93a94.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    single {
        retrofit.create(UserAPI::class.java)
    }

    viewModel { SplashViewModel() }
    viewModel { LoginViewModel(get<UserAPI>()) }
}