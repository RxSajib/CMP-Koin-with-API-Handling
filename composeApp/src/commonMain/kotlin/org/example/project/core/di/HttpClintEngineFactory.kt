package org.example.project.core.di

import io.ktor.client.engine.HttpClientEngine

// add expect class for iOS and Android
// implement actual implementation for android, ios , desktop
expect class HttpClintEngineFactory() {
    fun getHttpEngine() : HttpClientEngine
}