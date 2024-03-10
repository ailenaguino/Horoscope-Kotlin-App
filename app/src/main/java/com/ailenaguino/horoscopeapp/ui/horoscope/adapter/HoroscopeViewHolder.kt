package com.ailenaguino.horoscopeapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.horoscopeapp.databinding.ItemHoroscopeBinding
import com.ailenaguino.horoscopeapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscopeTitle.text =
            binding.tvHoroscopeTitle.context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener {
            startRotationAnimation(
                binding.ivHoroscope,
                callOnItem = { onItemSelected(horoscopeInfo) })
        }
    }

    fun startRotationAnimation(view: View, callOnItem: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator() // define el camino de la animacion, si es lineal es que va a tener la misma velocidad de principio a fin
            rotationBy(360f) //rota en si misma
            withEndAction { callOnItem() } //se ejecuta cuando termina la animacion
            start()
        }
    }
}