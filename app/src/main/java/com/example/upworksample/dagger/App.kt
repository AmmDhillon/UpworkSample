package com.example.upworksample.dagger

import android.app.Application
import com.example.upworksample.dagger.component.AppComponent
import com.example.upworksample.dagger.component.DaggerAppComponent
import com.example.upworksample.dagger.module.NetworkModule

class App : Application(){

    companion object{ lateinit var appComponent: AppComponent }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule(this))
            .build()
    }
}