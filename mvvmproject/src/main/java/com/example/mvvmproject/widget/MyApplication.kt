package com.example.mvvmproject.widget

import android.app.Application
import com.example.mvvmproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            val modules = listOf(appModule)
            modules(modules)
        }
    }
}