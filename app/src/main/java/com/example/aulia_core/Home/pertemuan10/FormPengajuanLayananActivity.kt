package com.example.aulia_core.Home.pertemuan10

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.aulia_core.data.database.AppDatabase
import com.example.aulia_core.data.entity.PengajuanLayananEntity
import com.example.aulia_core.databinding.ActivityFormPengajuanLayananBinding
import com.example.aulia_core.utils.NotificationHelper
import com.example.aulia_core.utils.ReminderHelper
import kotlinx.coroutines.launch
import java.util.Calendar

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

                    // ========== NOTIFIKASI LANGSUNG ==========
                    val intentNotif = Intent(this@FormPengajuanLayananActivity, TenthActivity::class.java)
                    intentNotif.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intentNotif.putExtra("OPEN_TAB", 3)  // ← LANGSUNG KE TAB STATUS

                    NotificationHelper.showNotification(
                        context = this@FormPengajuanLayananActivity,
                        title = "✅ Pengajuan Berhasil",
                        message = "Pengajuan $namaLayanan berhasil dikirim! Akan segera diproses.",
                        intent = intentNotif
                    )

                    // ========== REMINDER 1 MENIT ==========
                    val calendar = Calendar.getInstance().apply {
                        add(Calendar.MINUTE, 1)
                    }

                    // Intent untuk reminder (juga langsung ke tab Status)
                    val intentReminder = Intent(this@FormPengajuanLayananActivity, TenthActivity::class.java)
                    intentReminder.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intentReminder.putExtra("OPEN_TAB", 3)

                    ReminderHelper.setReminder(
                        context = this@FormPengajuanLayananActivity,
                        hour = calendar.get(Calendar.HOUR_OF_DAY),
                        minute = calendar.get(Calendar.MINUTE),
                        title = "⏰ Cek Status Pengajuan",
                        message = "Halo! Jangan lupa cek status pengajuan $namaLayanan Anda sekarang!",
                        targetActivity = TenthActivity::class.java,
                        openTab = 3  // ← TAMBAHKAN PARAMETER OPEN_TAB
                    )

                    Toast.makeText(
                        this@FormPengajuanLayananActivity,
                        "✅ Pengajuan berhasil! Notifikasi akan muncul.",
                        Toast.LENGTH_LONG
                    ).show()

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