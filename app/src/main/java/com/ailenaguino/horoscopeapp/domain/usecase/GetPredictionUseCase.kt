package com.ailenaguino.horoscopeapp.domain.usecase

import com.ailenaguino.horoscopeapp.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    //con la palabra reservada operator nos permitimos sobreescribir algunas funciones de la creacion de la clase
    suspend operator fun invoke(sign:String) = repository.getPrediction(sign)

}