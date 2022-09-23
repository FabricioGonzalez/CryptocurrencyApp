package com.teste.personal_tool_app.data.repositories.coin

import com.teste.personal_tool_app.data.remote.coin.CoinPaprikaApi
import com.teste.personal_tool_app.data.remote.coin.dto.CoinDetailDto
import com.teste.personal_tool_app.data.remote.coin.dto.CoinDto
import com.teste.personal_tool_app.domain.coin.repositories.CoinRepository
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