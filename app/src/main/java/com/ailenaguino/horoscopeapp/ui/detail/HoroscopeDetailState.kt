package com.ailenaguino.horoscopeapp.ui.detail

import com.ailenaguino.horoscopeapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()//es class porque requiere que le pasemos parametros
    data class Success(val prediction:String, val sign:String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}