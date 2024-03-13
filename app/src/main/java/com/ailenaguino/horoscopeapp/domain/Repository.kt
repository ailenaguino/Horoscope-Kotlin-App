package com.ailenaguino.horoscopeapp.domain

//el repositorio va a ser la comunicacion que va a tener la capa de data y la de dominio
interface Repository {
    suspend fun getPrediction(sign: String)
}