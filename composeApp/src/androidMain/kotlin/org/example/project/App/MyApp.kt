package org.example.project.App

import android.app.Application
import org.example.project.core.di.initKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            this
        }

    }
}