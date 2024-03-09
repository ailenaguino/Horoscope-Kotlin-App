package com.ailenaguino.horoscopeapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ailenaguino.horoscopeapp.databinding.ItemHoroscopeBinding
import com.ailenaguino.horoscopeapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo) {
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscopeTitle.text =
            binding.tvHoroscopeTitle.context.getString(horoscopeInfo.name)
    }
}