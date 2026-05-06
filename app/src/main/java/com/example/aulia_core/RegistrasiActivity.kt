package com.example.aulia_core

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.databinding.ActivityRegistrasiBinding
import java.util.Calendar

class RegistrasiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // DatePicker untuk Tanggal Lahir
        binding.etTanggalLahir.setOnClickListener {
            showDatePicker()
        }

        // Tombol Daftar
        binding.btnDaftar.setOnClickListener {
            if (validasiInput()) {
                simpanData()
            }
        }

        // Link ke Login
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }

    private fun validasiInput(): Boolean {
        var isValid = true

        // Ambil nilai input
        val nama = binding.etNama.text.toString().trim()
        val tanggalLahir = binding.etTanggalLahir.text.toString().trim()
        val jenisKelamin = getSelectedJenisKelamin()
        val agama = binding.etAgama.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()

        // Validasi Nama
        if (nama.isEmpty()) {
            binding.etNama.error = "Nama tidak boleh kosong!"
            isValid = false
        } else {
            binding.etNama.error = null
        }

        // Validasi Tanggal Lahir
        if (tanggalLahir.isEmpty()) {
            binding.etTanggalLahir.error = "Tanggal lahir tidak boleh kosong!"
            isValid = false
        } else {
            binding.etTanggalLahir.error = null
        }

        // Validasi Jenis Kelamin
        if (jenisKelamin.isEmpty()) {
            binding.tvErrorJenisKelamin.visibility = android.view.View.VISIBLE
            binding.tvErrorJenisKelamin.text = "Jenis kelamin harus dipilih!"
            isValid = false
        } else {
            binding.tvErrorJenisKelamin.visibility = android.view.View.GONE
        }

        // Validasi Agama
        if (agama.isEmpty()) {
            binding.etAgama.error = "Agama tidak boleh kosong!"
            isValid = false
        } else {
            binding.etAgama.error = null
        }

        // Validasi Username
        if (username.isEmpty()) {
            binding.etUsername.error = "Username tidak boleh kosong!"
            isValid = false
        } else {
            binding.etUsername.error = null
        }

        // Validasi Password
        if (password.isEmpty()) {
            binding.etPassword.error = "Password tidak boleh kosong!"
            isValid = false
        } else if (password.length < 4) {
            binding.etPassword.error = "Password minimal 4 karakter!"
            isValid = false
        } else {
            binding.etPassword.error = null
        }

        // Validasi Confirm Password
        if (confirmPassword.isEmpty()) {
            binding.etConfirmPassword.error = "Konfirmasi password tidak boleh kosong!"
            isValid = false
        } else if (password != confirmPassword) {
            binding.etConfirmPassword.error = "Password dan Konfirmasi Password tidak sama!"
            isValid = false
        } else {
            binding.etConfirmPassword.error = null
        }

        return isValid
    }

    private fun simpanData() {
        val nama = binding.etNama.text.toString().trim()
        val tanggalLahir = binding.etTanggalLahir.text.toString().trim()
        val jenisKelamin = getSelectedJenisKelamin()
        val agama = binding.etAgama.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("nama", nama)
        editor.putString("tanggal_lahir", tanggalLahir)
        editor.putString("jenis_kelamin", jenisKelamin)
        editor.putString("agama", agama)
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()

        // Tampilkan pesan sukses di TextView (bukan Toast)
        binding.tvSuccessMessage.text = "✅ Registrasi Berhasil! Silakan Login."
        binding.tvSuccessMessage.visibility = android.view.View.VISIBLE

        // Pindah ke halaman login setelah 2 detik
        android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }, 2000)
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(this, { _, year, month, dayOfMonth ->
            val tanggal = "$dayOfMonth/${month + 1}/$year"
            binding.etTanggalLahir.setText(tanggal)
            binding.etTanggalLahir.error = null
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun getSelectedJenisKelamin(): String {
        return when (binding.rgJenisKelamin.checkedRadioButtonId) {
            binding.rbLaki.id -> "Laki-laki"
            binding.rbPerempuan.id -> "Perempuan"
            else -> ""
        }
    }
}