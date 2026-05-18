package com.example.aulia_core.Home.pertemuan9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.databinding.ActivityNinthBinding

class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ==================== 1. TOOLBAR BACK BUTTON ====================
        setSupportActionBar(binding.toolbarNinth)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pertemuan 9"
        binding.toolbarNinth.setNavigationOnClickListener { finish() }

        // ==================== 2. CHIP ONCLICK (LANGSUNG PER CHIP) ====================
        // Hapus atau comment kode yang memanggil chipGroupFilter
        // binding.chipGroupFilter.setOnCheckedStateChangeListener { ... }  // ← HAPUS INI

        // Ganti dengan ini:
        binding.chipTerbaru.setOnClickListener {
            Toast.makeText(this, "Filter: Terbaru", Toast.LENGTH_SHORT).show()
        }
        binding.chipPenting.setOnClickListener {
            Toast.makeText(this, "Filter: Penting", Toast.LENGTH_SHORT).show()
        }
        binding.chipBelumDibaca.setOnClickListener {
            Toast.makeText(this, "Filter: Belum Dibaca", Toast.LENGTH_SHORT).show()
        }

        // ==================== 3. LOGIN VALIDATION ====================
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.textInputLayoutEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.textInputLayoutEmail.error = "Format email tidak valid"
                return@setOnClickListener
            } else {
                binding.textInputLayoutEmail.error = null
                binding.textInputLayoutEmail.helperText = "Email valid"
            }

            if (password.isEmpty()) {
                binding.textInputLayoutPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            } else if (password.length < 6) {
                binding.textInputLayoutPassword.error = "Password minimal 6 karakter"
                return@setOnClickListener
            } else {
                binding.textInputLayoutPassword.error = null
            }

            Toast.makeText(this, "✅ Login Berhasil!\nEmail: $email", Toast.LENGTH_LONG).show()
        }

        // ==================== 4. GRIDLAYOUT MENU BUTTONS ====================
        binding.btnGridMenu1.setOnClickListener {
            Toast.makeText(this, "📊 Dashboard Aulia Core", Toast.LENGTH_SHORT).show()
        }
        binding.btnGridMenu2.setOnClickListener {
            Toast.makeText(this, "👥 Data Pengguna", Toast.LENGTH_SHORT).show()
        }
        binding.btnGridMenu3.setOnClickListener {
            Toast.makeText(this, "📝 Layanan Tersedia", Toast.LENGTH_SHORT).show()
        }
        binding.btnGridMenu4.setOnClickListener {
            Toast.makeText(this, "ℹ️ Informasi Aplikasi", Toast.LENGTH_SHORT).show()
        }
        binding.btnGridMenu5.setOnClickListener {
            Toast.makeText(this, "📢 Pengumuman Terbaru", Toast.LENGTH_SHORT).show()
        }
        binding.btnGridMenu6.setOnClickListener {
            Toast.makeText(this, "💰 Laporan Keuangan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}