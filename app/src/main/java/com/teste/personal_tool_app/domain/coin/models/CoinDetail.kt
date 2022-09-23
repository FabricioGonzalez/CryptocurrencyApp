package com.teste.personal_tool_app.domain.coin.models

import com.teste.personal_tool_app.data.remote.coin.dto.TeamMember

data class CoinDetail(
    val coinId: String, val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
