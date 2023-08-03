package com.awakelab.oskar.ejercicio5m6.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.awakelab.oskar.ejercicio5m6.databinding.FragmentListadoTerrenosBinding


class ListadoTerrenos : Fragment() {
    lateinit var binding: FragmentListadoTerrenosBinding
    private val terrenoVM: TerrenoVM by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListadoTerrenosBinding.inflate(layoutInflater, container, false)
        initAdapter()
        binding.btnCargar.setOnClickListener {
            terrenoVM.getAllTerrenos()
        }

        return binding.root
    }

    private fun initAdapter() {
        //   terrenoVM.getAllTerrenos()
        val adapter = AdapterTerreno()
        binding.rv.adapter = adapter

        terrenoVM.terrenosLiveData.observe(viewLifecycleOwner) {

            adapter.setData(it)
        }

        //    adapter.setData(TerrenoVM.)
    }

}