package com.teste.criptocurrencyapp.domain.usecases.get_coin

import com.teste.criptocurrencyapp.common.Resource
import com.teste.criptocurrencyapp.data.remote.dto.CoinDetailDto
import com.teste.criptocurrencyapp.data.remote.dto.ToCoin
import com.teste.criptocurrencyapp.data.remote.dto.ToCoinDetail
import com.teste.criptocurrencyapp.domain.models.Coin
import com.teste.criptocurrencyapp.domain.models.CoinDetail
import com.teste.criptocurrencyapp.domain.repositories.CoinRepository
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
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).ToCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected Error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server. Check your internet connection!"))
        }
    }
}