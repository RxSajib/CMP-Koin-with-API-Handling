package org.example.project.core.di

import org.example.project.data.API
import org.example.project.data.APIResponse
import org.example.project.screen.HomeViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class LIstModule {

    @Factory(binds = [API::class])
    fun proVideAPIResponse() : APIResponse = APIResponse()

    @KoinViewModel
    fun provideHomeViewModel(api: API) : HomeViewModel = HomeViewModel(api)
}