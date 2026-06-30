package com.example.aulia_core.Home.pertemuan3

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.Home.pertemuan10.TenthActivity
import com.example.aulia_core.Home.pertemuan2.SecondActivity
import com.example.aulia_core.Home.pertemuan4.DailyGlowActivity
import com.example.aulia_core.Home.pertemuan4.BlueMotivationActivity
import com.example.aulia_core.Home.pertemuan5.WebViewActivity
import com.example.aulia_core.databinding.ActivityWelcomeBinding
import com.example.aulia_core.utils.NotificationHelper
import com.example.aulia_core.utils.PermissionHelper
import com.example.aulia_core.utils.ReminderHelper
import java.util.Calendar

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                Toast.makeText(this, "Notifikasi diizinkan", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Notifikasi ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("USERNAME")
        binding.tvUsername.text = username

        // ========== PERMISSION NOTIFIKASI ==========
        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        // ========== TOMBOL KIRIM NOTIFIKASI ==========
        binding.btnKirimNotifikasi.setOnClickListener {
            val intent = Intent(this, TenthActivity::class.java)
            NotificationHelper.showNotification(
                context = this,
                title = "📬 Pengajuan Layanan Desa",
                message = "Halo, ada pengajuan layanan baru yang menunggu verifikasi!",
                intent = intent
            )
            Toast.makeText(this, "Notifikasi dikirim!", Toast.LENGTH_SHORT).show()
        }

        // ========== TOMBOL SET REMINDER 1 MENIT ==========
        binding.btnSetReminder.setOnClickListener {
            val calendar = Calendar.getInstance().apply {
                add(Calendar.MINUTE, 1)
            }

            val intent = Intent(this, TenthActivity::class.java)

            ReminderHelper.setReminder(
                context = this,
                hour = calendar.get(Calendar.HOUR_OF_DAY),
                minute = calendar.get(Calendar.MINUTE),
                title = "⏰ Reminder Bina Desa",
                message = "Halo! Ini adalah pengingat untuk mengecek pengajuan layanan Anda.",
                targetActivity = TenthActivity::class.java
            )

            Toast.makeText(this, "⏰ Reminder akan muncul dalam 1 menit!", Toast.LENGTH_SHORT).show()
        }

        // ========== TOMBOL EXISTING ==========
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.btnDailyGlow.setOnClickListener {
            startActivity(Intent(this, DailyGlowActivity::class.java))
        }

        binding.btnMotivation.setOnClickListener {
            startActivity(Intent(this, BlueMotivationActivity::class.java))
        }

        binding.btnBinaDesa.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}