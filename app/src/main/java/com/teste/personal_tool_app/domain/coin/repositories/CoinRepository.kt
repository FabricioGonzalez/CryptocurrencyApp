package com.teste.personal_tool_app.domain.coin.repositories

import com.teste.personal_tool_app.data.remote.coin.dto.CoinDetailDto
import com.teste.personal_tool_app.data.remote.coin.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}