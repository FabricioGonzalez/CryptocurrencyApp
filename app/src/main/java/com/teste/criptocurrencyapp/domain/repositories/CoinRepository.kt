package com.teste.criptocurrencyapp.domain.repositories

import com.teste.criptocurrencyapp.data.remote.dto.CoinDetailDto
import com.teste.criptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}