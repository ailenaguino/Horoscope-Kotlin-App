package com.ailenaguino.horoscopeapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ailenaguino.horoscopeapp.domain.model.HoroscopeModel
import com.ailenaguino.horoscopeapp.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    fun getPrediction(hm: HoroscopeModel){
        viewModelScope.launch {
            //hilo principal
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) { getPredictionUseCase(hm.name) } //hilo secundario
            if(result!=null){
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, hm)
            }else{
                _state.value = HoroscopeDetailState.Error("An error has occurred")
            }
        }
    }
}