package com.teste.personal_tool_app.di

import android.content.Context
import com.teste.personal_tool_app.ConnectivityObserver
import com.teste.personal_tool_app.NetworkConnectivityObserver
import com.teste.personal_tool_app.common.Constants
import com.teste.personal_tool_app.data.remote.coin.CoinPaprikaApi
import com.teste.personal_tool_app.data.repositories.coin.CoinRepositoryImpl
import com.teste.personal_tool_app.domain.coin.repositories.CoinRepository
import com.teste.personal_tool_app.presentation.nofication.services.NotificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideNotificationService(@ApplicationContext context: Context): NotificationService {
        return NotificationService(context)
    }

    @Provides
    fun provideNetworkObserver(@ApplicationContext context: Context): ConnectivityObserver {
        return NetworkConnectivityObserver(context)
    }
}