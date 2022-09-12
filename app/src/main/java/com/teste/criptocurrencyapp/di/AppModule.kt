package com.teste.criptocurrencyapp.di

import com.teste.criptocurrencyapp.common.Constants
import com.teste.criptocurrencyapp.data.remote.CoinPaprikaApi
import com.teste.criptocurrencyapp.data.repositories.CoinRepositoryImpl
import com.teste.criptocurrencyapp.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePaprikaApi():CoinPaprikaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}