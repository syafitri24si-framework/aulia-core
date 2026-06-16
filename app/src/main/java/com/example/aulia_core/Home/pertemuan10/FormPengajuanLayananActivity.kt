package com.example.aulia_core.Home.pertemuan10

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aulia_core.data.database.AppDatabase
import com.example.aulia_core.data.entity.PengajuanLayananEntity
import com.example.aulia_core.databinding.ActivityFormPengajuanLayananBinding
import kotlinx.coroutines.launch

class FormPengajuanLayananActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormPengajuanLayananBinding
    private lateinit var db: AppDatabase
    private var namaLayanan: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormPengajuanLayananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)
        namaLayanan = intent.getStringExtra("NAMA_LAYANAN") ?: "Layanan Digital"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Form Pengajuan: $namaLayanan"

        binding.tvNamaLayanan.text = namaLayanan

        binding.btnSimpan.setOnClickListener {
            val nama = binding.etNamaPemohon.text.toString().trim()
            val nik = binding.etNik.text.toString().trim()

            if (nama.isNotEmpty() && nik.isNotEmpty()) {
                lifecycleScope.launch {
                    val pengajuan = PengajuanLayananEntity(
                        namaLayanan = namaLayanan,
                        namaPemohon = nama,
                        nik = nik,
                        status = "Diproses",
                        createdAt = System.currentTimeMillis()
                    )
                    db.pengajuanLayananDao().insert(pengajuan)
                    Toast.makeText(this@FormPengajuanLayananActivity, "Pengajuan berhasil disimpan!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}