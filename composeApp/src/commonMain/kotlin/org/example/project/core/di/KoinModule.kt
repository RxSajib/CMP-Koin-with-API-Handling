package org.example.project.core.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
class KoinModule {

    // httpClint instance input as engine
    // for Android and Desktop engine okHttp
    // for iOS engine Darwin
    @Single
    @AuthOkHttpClint
    fun authHttpClint(engine: HttpClientEngine) : HttpClient = HttpClient(engine = engine){
        // configure http client

    }

    @Single
    @NoAuthOkHttpClint
    fun noAuthHttpClint(engine: HttpClientEngine) : HttpClient = HttpClient(engine = engine){
        // configure http client

    }

    @Factory
    fun provideEngine() : HttpClientEngine = HttpClintEngineFactory().getHttpEngine()
}

@Named
annotation class AuthOkHttpClint
@Named
annotation class NoAuthOkHttpClint

