package com.ailenaguino.horoscopeapp.data

import com.ailenaguino.horoscopeapp.domain.Repository

class RepositoryImpl : Repository {
    override suspend fun getPrediction(sign: String) {
        //Llamar retrofit
    }
}