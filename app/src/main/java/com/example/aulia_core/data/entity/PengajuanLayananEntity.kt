package com.example.aulia_core.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengajuan_layanan")
data class PengajuanLayananEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val namaLayanan: String,      // Nama layanan yang dipilih
    val namaPemohon: String,      // Nama lengkap pemohon
    val nik: String,              // NIK pemohon
    val status: String,           // "Diproses", "Selesai", "Ditolak"
    val createdAt: Long           // Timestamp pengajuan
)