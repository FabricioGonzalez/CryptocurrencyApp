package com.teste.criptocurrencyapp.presentation.coin_detail

import com.teste.criptocurrencyapp.domain.models.Coin
import com.teste.criptocurrencyapp.domain.models.CoinDetail

data class CoinDetailState(val isLoading:Boolean = false,
                           val coin: CoinDetail? = null,
                           val error: String = "")