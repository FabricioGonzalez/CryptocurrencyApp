package com.teste.personal_tool_app.presentation.coin.coin_list

import com.teste.personal_tool_app.domain.coin.models.Coin

data class CoinListState(val isLoading:Boolean = false,
                         val coins: List<Coin> = emptyList(),
                         val error: String = "")