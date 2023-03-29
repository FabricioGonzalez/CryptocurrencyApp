package com.teste.personal_tool_app.di

import android.app.Application
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@UnstableApi
@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideVideoPlayer(app: Application): Player {

// Create a HLS media source pointing to a playlist uri.
        /*val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")
*/
        return ExoPlayer
            .Builder(app)
            /*.setMediaSourceFactory(HlsMediaSource.Factory(dataSourceFactory))*/
            .build()
    }

}