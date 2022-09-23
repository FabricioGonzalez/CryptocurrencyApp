package com.teste.personal_tool_app.domain.coin.usecases.get_coins

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.data.remote.coin.dto.ToCoin
import com.teste.personal_tool_app.domain.coin.models.Coin
import com.teste.personal_tool_app.domain.coin.repositories.CoinRepository
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
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected Error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach the server. Check your internet connection!"))
        }
    }
}