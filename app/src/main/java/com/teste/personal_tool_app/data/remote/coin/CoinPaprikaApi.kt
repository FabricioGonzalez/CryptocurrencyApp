package com.teste.personal_tool_app.data.remote.coin

import com.teste.personal_tool_app.data.remote.coin.dto.CoinDetailDto
import com.teste.personal_tool_app.data.remote.coin.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun GetCoin(@Path("coinId") coinId: String) : CoinDetailDto
}