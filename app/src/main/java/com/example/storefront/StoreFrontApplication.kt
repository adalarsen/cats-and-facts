package com.example.storefront

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StoreFrontApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}