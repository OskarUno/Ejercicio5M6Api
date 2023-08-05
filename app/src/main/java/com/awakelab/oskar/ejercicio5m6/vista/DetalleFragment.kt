package com.awakelab.oskar.ejercicio5m6.vista

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.ejercicio5m6.R
import com.awakelab.oskar.ejercicio5m6.databinding.FragmentDetalleBinding

private const val ARG_PARAM1 = "id"

class DetalleFragment : Fragment() {
    private lateinit var binding: FragmentDetalleBinding
    private val terrenoVM: TerrenoVM by activityViewModels()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)

        terrenoVM.terrenoLiveData(param1.toString()).observe(viewLifecycleOwner) {
            binding.tvId.text = "Id: " + it.id
            binding.tvTipo.text = "Tipo: " + it.tipo
            binding.tvPrecio.text = "Precio: " + it.precio.toString()
            binding.img.load(it.imagen)
        }

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_detalleFragment_to_listadoTerrenos)
        }
        return binding.root
    }

}