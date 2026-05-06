package com.example.aulia_core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        // Tombol Login
        binding.btnMasuk.setOnClickListener {
            val username = binding.inputUsername.text.toString().trim()
            val password = binding.inputPassword.text.toString().trim()

            // Ambil data dari SharedPreferences (hasil registrasi)
            val savedUsername = sharedPref.getString("username", "")
            val savedPassword = sharedPref.getString("password", "")

            // 🔵 VALIDASI LOGIN dengan 2 RULE
            val isValid = when {
                // Rule 1: Username kosong atau Password kosong
                username.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, "Username dan Password tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                    false
                }
                // Rule 2: Username = Password (seperti praktikum)
                username == password -> {
                    Toast.makeText(this, "Login Berhasil (Username = Password)!", Toast.LENGTH_SHORT).show()
                    true
                }
                // Rule 3: Username dan Password cocok dengan data registrasi
                username == savedUsername && password == savedPassword -> {
                    Toast.makeText(this, "Login Berhasil! Selamat datang $username", Toast.LENGTH_SHORT).show()
                    true
                }
                // Rule 4: Data tidak cocok
                else -> {
                    Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show()
                    false
                }
            }

            if (isValid) {
                // Simpan status login
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username_login", username)
                editor.apply()

                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            }
        }

        // Tombol ke halaman Registrasi
        binding.tvDaftarSekarang.setOnClickListener {
            startActivity(Intent(this, RegistrasiActivity::class.java))
        }
    }
}