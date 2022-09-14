package com.teste.personal_tool_app.domain.repositories

import com.teste.personal_tool_app.data.remote.dto.CoinDetailDto
import com.teste.personal_tool_app.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}