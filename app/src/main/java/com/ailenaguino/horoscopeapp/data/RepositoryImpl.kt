package com.ailenaguino.horoscopeapp.data

import android.util.Log
import com.ailenaguino.horoscopeapp.data.network.HoroscopeApiService
import com.ailenaguino.horoscopeapp.domain.Repository
import com.ailenaguino.horoscopeapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject


//ahora al tener el modulo que provee Retrofit y el apiservice, cuando los llamemos, va a buscar en todos los modulos a ver si alguno los provee
class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscopeInfoForSpecificSign(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("prediction", "Ha fallado: ${it.message}") }
        return null
    }
}