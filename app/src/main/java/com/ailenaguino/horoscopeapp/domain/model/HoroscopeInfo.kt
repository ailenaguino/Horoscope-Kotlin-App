package com.ailenaguino.horoscopeapp.domain.model

import com.ailenaguino.horoscopeapp.R

sealed class HoroscopeInfo( val img: Int, val name: Int){
    object Capricorn:HoroscopeInfo(R.drawable.capricornio, R.string.capricorn)
}