package com.example.aulia_core.Home.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aulia_core.data.entity.PengajuanLayananEntity
import com.example.aulia_core.databinding.ItemPengajuanLayananBinding
import java.text.SimpleDateFormat
import java.util.*

class PengajuanLayananAdapter(
    private val items: List<PengajuanLayananEntity>,
    private val onDeleteClick: (PengajuanLayananEntity) -> Unit
) : RecyclerView.Adapter<PengajuanLayananAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemPengajuanLayananBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPengajuanLayananBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvNamaLayanan.text = item.namaLayanan
        holder.binding.tvNamaPemohon.text = "👤 ${item.namaPemohon} | NIK: ${item.nik}"
        holder.binding.tvStatus.text = item.status

        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        holder.binding.tvTanggal.text = dateFormat.format(Date(item.createdAt))

        when (item.status) {
            "Diproses" -> holder.binding.tvStatus.setTextColor(0xFFFF9800.toInt())
            "Selesai" -> holder.binding.tvStatus.setTextColor(0xFF4CAF50.toInt())
            "Ditolak" -> holder.binding.tvStatus.setTextColor(0xFFE53935.toInt())
        }

        holder.binding.btnDelete.setOnClickListener {
            onDeleteClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}