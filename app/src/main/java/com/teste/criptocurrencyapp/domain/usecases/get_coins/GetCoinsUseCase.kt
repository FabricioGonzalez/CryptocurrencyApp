package com.teste.criptocurrencyapp.domain.usecases.get_coins

import com.teste.criptocurrencyapp.common.Resource
import com.teste.criptocurrencyapp.data.remote.dto.ToCoin
import com.teste.criptocurrencyapp.domain.models.Coin
import com.teste.criptocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val
    repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {
                it.ToCoin()
            }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected Error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server. Check your internet connection!"))
        }
    }
}