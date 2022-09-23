package com.teste.personal_tool_app.domain.coin.usecases.get_coin

import com.teste.personal_tool_app.common.Resource
import com.teste.personal_tool_app.data.remote.coin.dto.ToCoinDetail
import com.teste.personal_tool_app.domain.coin.models.CoinDetail
import com.teste.personal_tool_app.domain.coin.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val
    repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).ToCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected Error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach the server. Check your internet connection!"))
        }
    }
}