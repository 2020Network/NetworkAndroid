package com.example.mvvmproject.di

import com.example.mvvmproject.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { SplashViewModel() }
}