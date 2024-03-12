package com.ailenaguino.horoscopeapp.ui.detail

sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()//es class porque requiere que le pasemos parametros
    data class Success(val data:String):HoroscopeDetailState()
}