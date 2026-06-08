package com.example.aulia_core.Home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aulia_core.databinding.ItemLayananDigitalBinding

class LayananDigitalAdapter(
    private val layananList: List<LayananDigitalModel>,
    private val onItemClick: (LayananDigitalModel) -> Unit
) : RecyclerView.Adapter<LayananDigitalAdapter.LayananDigitalViewHolder>() {

    inner class LayananDigitalViewHolder(val binding: ItemLayananDigitalBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LayananDigitalViewHolder {
        val binding = ItemLayananDigitalBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LayananDigitalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LayananDigitalViewHolder, position: Int) {
        val item = layananList[position]
        with(holder.binding) {
            tvLayananName.text = item.name
            tvLayananDesc.text = item.description

            // Load gambar dari URL menggunakan Glide
            Glide.with(holder.itemView.context)
                .load(item.iconUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(imgIcon)

            root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun getItemCount(): Int = layananList.size
}