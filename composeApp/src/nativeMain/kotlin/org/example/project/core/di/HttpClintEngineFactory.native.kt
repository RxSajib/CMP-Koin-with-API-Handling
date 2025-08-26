package org.example.project.core.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class HttpClintEngineFactory {
    actual fun getHttpEngine(): HttpClientEngine {
        return Darwin.create()
    }
}