package com.teste.personal_tool_app.presentation.coin_detail

import com.teste.personal_tool_app.domain.models.CoinDetail

data class CoinDetailState(val isLoading:Boolean = false,
                           val coin: CoinDetail? = null,
                           val error: String = "")