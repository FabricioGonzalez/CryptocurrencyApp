package com.teste.personal_tool_app.presentation.coin.coin_list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teste.personal_tool_app.ConnectivityObserver
import com.teste.personal_tool_app.Status
import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.domain.coin.usecases.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    private var _connectionState = mutableStateOf(Status.Unavailable)
    var connectionState: State<Status> = _connectionState

    init {
        getCoins()
        viewModelScope.launch {
            connectivityObserver.observe().collect {
                data ->
                _connectionState.value = data
            }
        }
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An Unexpected Error Occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}