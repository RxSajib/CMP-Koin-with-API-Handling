package org.example.project.core.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
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
        install(ContentNegotiation){
            json(json = Json{
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            })
        }

        install(HttpTimeout){
            socketTimeoutMillis = 3000
            requestTimeoutMillis = 3000
            connectTimeoutMillis = 3000
        }

        install(DefaultRequest){
            url {
                host = "jsonplaceholder.typicode.com"
                protocol = URLProtocol.HTTPS
            }
        }

        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    @Single
    @NoAuthOkHttpClint
    fun noAuthHttpClint(engine: HttpClientEngine) : HttpClient = HttpClient(engine = engine){
        // configure http client
        install(ContentNegotiation){
            json(json = Json{
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            })
        }

        install(HttpTimeout){
            socketTimeoutMillis = 3000
            requestTimeoutMillis = 3000
            connectTimeoutMillis = 3000
        }

        install(DefaultRequest){
            url {
                host = "jsonplaceholder.typicode.com"
                protocol = URLProtocol.HTTPS
            }
        }

        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    @Factory
    fun provideEngine() : HttpClientEngine = HttpClintEngineFactory().getHttpEngine()
}

@Named
annotation class AuthOkHttpClint
@Named
annotation class NoAuthOkHttpClint

