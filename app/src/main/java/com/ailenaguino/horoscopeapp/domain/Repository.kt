package com.ailenaguino.horoscopeapp.domain

import com.ailenaguino.horoscopeapp.domain.model.PredictionModel

//aca no puedo poner un inject asique lo inyectamos desde un module
//el repositorio va a ser la comunicacion que va a tener la capa de data y la de dominio
interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}