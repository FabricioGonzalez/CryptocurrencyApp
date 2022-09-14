package com.teste.personal_tool_app.data.repositories

import com.teste.personal_tool_app.data.remote.CoinPaprikaApi
import com.teste.personal_tool_app.data.remote.dto.CoinDetailDto
import com.teste.personal_tool_app.data.remote.dto.CoinDto
import com.teste.personal_tool_app.domain.repositories.CoinRepository
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