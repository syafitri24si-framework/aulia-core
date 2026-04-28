package com.example.aulia_core.pertemuan3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.databinding.ActivityWelcomeBinding
import com.example.aulia_core.pertemuan_2.SecondActivity
import com.example.aulia_core.pertemuan4.DailyGlowActivity
import com.example.aulia_core.pertemuan4.BlueMotivationActivity
import com.example.aulia_core.pertemuan5.WebViewActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")
        binding.tvUsername.text = username

        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.btnDailyGlow.setOnClickListener {
            startActivity(Intent(this, DailyGlowActivity::class.java))
        }

        binding.btnMotivation.setOnClickListener {
            startActivity(Intent(this, BlueMotivationActivity::class.java))
        }

        // 🔥 BUTTON BINA DESA
        binding.btnBinaDesa.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // 🔥 LOGOUT
        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}