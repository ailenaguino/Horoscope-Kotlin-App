package com.ailenaguino.horoscopeapp.domain.model

import com.google.gson.annotations.SerializedName

//hacemos esta version de predictionResponse sin serialized name en dominio
//ya que serialized name viene de una libreria de android y eso al dominio no le deberia interesar
data class PredictionModel (
    val horoscope: String,
    val sign: String
)