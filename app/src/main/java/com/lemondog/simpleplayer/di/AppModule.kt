package com.lemondog.simpleplayer.di

import android.content.Context
import com.lemondog.simpleplayer.common.coroutine.ApplicationCoroutineScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    internal fun provideApplicationCoroutineScope(): ApplicationCoroutineScope =
        ApplicationCoroutineScope(SupervisorJob())
}
