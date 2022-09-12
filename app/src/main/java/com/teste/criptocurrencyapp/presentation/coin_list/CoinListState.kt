package com.teste.criptocurrencyapp.presentation.coin_list

import com.teste.criptocurrencyapp.domain.models.Coin

data class CoinListState(val isLoading:Boolean = false,
val coins: List<Coin> = emptyList(),
val error: String = "")