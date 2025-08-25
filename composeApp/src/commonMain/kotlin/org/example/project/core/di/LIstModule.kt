package org.example.project.core.di

import org.example.project.screen.HomeViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Module

@Module
class LIstModule {

    @KoinViewModel
    fun provideHomeViewModel() : HomeViewModel = HomeViewModel()
}