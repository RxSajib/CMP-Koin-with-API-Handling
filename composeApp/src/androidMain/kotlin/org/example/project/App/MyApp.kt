package org.example.project.App

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.example.project.core.di.initKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            this
        }
        Napier.base(DebugAntilog())
    }
}