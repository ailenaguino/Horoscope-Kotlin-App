package com.ailenaguino.horoscopeapp.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ailenaguino.horoscopeapp.R
import com.ailenaguino.horoscopeapp.databinding.FragmentHoroscopeBinding
import com.ailenaguino.horoscopeapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    private lateinit var horAdapter: HoroscopeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // este metodo es una vez que la vista ya fue creada
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    private fun initRecyclerView() {
        horAdapter = HoroscopeAdapter()

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context, 2) //pa que sea una grilla de 2 columnas en vez de una lista
            adapter = horAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch { //Esta es una corrutina que iniciamos y que se engancha al ciclo de vida del fragment.
            repeatOnLifecycle(Lifecycle.State.CREATED){
                horoscopeViewModel.horoscope.collect{ //este collect le dice al fragment que se suscriba/enganche al vm horoscope, entonces cada que este cambia, se ejecuta lo que esta dentro de collect
                    horAdapter.updateList(it)
                }
            }
        }
    }

}