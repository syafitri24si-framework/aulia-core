package com.example.aulia_core.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aulia_core.databinding.ActivityWelcomeBinding
import com.google.android.material.snackbar.Snackbar
import com.example.aulia_core.pertemuan_2.SecondActivity
import com.example.aulia_core.pertemuan4.DailyGlowActivity
import com.example.aulia_core.pertemuan4.PinkMotivationActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        // ViewBinding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Padding system
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // =======================
        // DATA DARI LOGIN
        // =======================
        val username = intent.getStringExtra("USERNAME")
        Toast.makeText(this, "Data: $username", Toast.LENGTH_SHORT).show()

        binding.tvWelcome.text = "Welcome👋"
        binding.tvUsername.text = username

        // =======================
        // DATA YANG DIKIRIM KE HALAMAN LAIN
        // =======================
        val judul = "Halaman Utama"
        val deskripsi = "Selamat datang di aplikasi pink kamu 💖"

        // =======================
        // TOMBOL 1 — RUMUS
        // =======================
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("judul", judul)
            intent.putExtra("deskripsi", deskripsi)
            startActivity(intent)
        }

        // =======================
        // TOMBOL 2 — DAILY GLOW
        // =======================
        binding.btnDailyGlow.setOnClickListener {
            val intent = Intent(this, DailyGlowActivity::class.java)
            intent.putExtra("judul", judul)
            intent.putExtra("deskripsi", deskripsi)
            startActivity(intent)
        }

        // =======================
        // TOMBOL 3 — MOTIVATION
        // =======================
        binding.btnMotivation.setOnClickListener {
            val intent = Intent(this, PinkMotivationActivity::class.java)
            intent.putExtra("judul", judul)
            intent.putExtra("deskripsi", deskripsi)
            startActivity(intent)
        }

        // =======================
        // TOMBOL 4 — LOGOUT
        // =======================
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(binding.main, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}