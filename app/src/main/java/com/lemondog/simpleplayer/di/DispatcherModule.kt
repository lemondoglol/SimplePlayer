package com.lemondog.simpleplayer.di

import com.lemondog.simpleplayer.common.coroutine.DefaultDispatcherProvider
import com.lemondog.simpleplayer.common.coroutine.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {
    /**
     * Coroutines
     * */
    @Binds
    @Singleton
    abstract fun bindDispatcherProvider(
        defaultDispatcherProvider: DefaultDispatcherProvider,
    ): DispatcherProvider
}