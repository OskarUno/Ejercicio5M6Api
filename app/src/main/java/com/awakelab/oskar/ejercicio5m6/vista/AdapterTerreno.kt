package com.awakelab.oskar.ejercicio5m6.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.awakelab.oskar.ejercicio5m6.R
import com.awakelab.oskar.ejercicio5m6.data.local.TerrenoEntity
import com.awakelab.oskar.ejercicio5m6.databinding.ItemTerrenoBinding

class AdapterTerreno : RecyclerView.Adapter<AdapterTerreno.ItemTerrenoViewHolder>() {
    lateinit var binding: ItemTerrenoBinding
    private val listItemTerrenos = mutableListOf<TerrenoEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AdapterTerreno.ItemTerrenoViewHolder {
        binding = ItemTerrenoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemTerrenoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemTerrenos.size
    }

    override fun onBindViewHolder(holder: ItemTerrenoViewHolder, position: Int) {
        val tereno = listItemTerrenos[position]
        holder.bind(tereno)
    }

    fun setData(terreno: List<TerrenoEntity>) {
        this.listItemTerrenos.clear()
        this.listItemTerrenos.addAll(terreno)
        notifyDataSetChanged()
    }

    class ItemTerrenoViewHolder(val v: ItemTerrenoBinding) : RecyclerView.ViewHolder(v.root) {
        fun bind(terreno: TerrenoEntity) {

            v.imageView.load(terreno.imagen)
            v.cv.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("id", terreno.id)
                Navigation.findNavController(v.root)
                    .navigate(R.id.action_listadoTerrenos_to_detalleFragment, bundle)
            }
        }
    }
}