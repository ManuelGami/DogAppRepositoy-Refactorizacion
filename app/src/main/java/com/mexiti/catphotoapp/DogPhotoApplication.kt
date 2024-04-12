package com.mexiti.catphotoapp

import android.app.Application
import com.mexiti.catphotoapp.data.AppContainer
import com.mexiti.catphotoapp.data.DefaultAppContainer

class DogPhotoApplication:Application() {
lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }
}