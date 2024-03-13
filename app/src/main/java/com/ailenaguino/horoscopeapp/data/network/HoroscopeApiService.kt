package com.ailenaguino.horoscopeapp.data.network

import com.ailenaguino.horoscopeapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    //Las corrutinas tiene que ir en funciones suspend
    @GET("/{sign}")
    suspend fun getHoroscopeInfoForSpecificSign(@Path("sign") s: String):PredictionResponse
}