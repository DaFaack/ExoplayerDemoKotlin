package com.relsellglobal.exoplayerdemokotlin.di

import android.content.Context
import com.relsellglobal.exoplayerdemokotlin.BaseApplication
import com.google.android.exoplayer2.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app : Context) : BaseApplication{
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun providesExoplayer(@ApplicationContext app : Context) : ExoPlayer {
        return ExoPlayer.Builder(app).build()
    }

}