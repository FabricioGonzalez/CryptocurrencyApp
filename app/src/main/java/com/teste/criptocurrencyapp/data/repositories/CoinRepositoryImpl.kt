package com.teste.criptocurrencyapp.data.repositories

import com.teste.criptocurrencyapp.data.remote.CoinPaprikaApi
import com.teste.criptocurrencyapp.data.remote.dto.CoinDetailDto
import com.teste.criptocurrencyapp.data.remote.dto.CoinDto
import com.teste.criptocurrencyapp.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.GetCoin(coinId)
    }
}