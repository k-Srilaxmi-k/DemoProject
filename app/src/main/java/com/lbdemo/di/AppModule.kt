package com.lbdemo.di

import com.lbdemo.data.RemoteRepositoryImpl
import  com.lbdemo.domain.repository.Repository
import com.lbdemo.domain.usecase.FetchDetails
import com.lbdemo.domain.usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module
@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRepository(): Repository = RemoteRepositoryImpl()

    @Provides
    fun provideUseCases(repository: Repository) = UseCases(
        fetchDetails = FetchDetails(repository)
    )
}