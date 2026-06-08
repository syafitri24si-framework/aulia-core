package com.example.aulia_core

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.onboarding.OnboardingActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)
            val hasSeenOnboarding = sharedPref.getBoolean("hasSeenOnboarding", false)

            when {
                // Case 1: Sudah login -> langsung ke BaseActivity
                isLogin -> {
                    startActivity(Intent(this, BaseActivity::class.java))
                }
                // Case 2: Belum pernah lihat onboarding -> tampilkan onboarding
                !hasSeenOnboarding -> {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                }
                // Case 3: Sudah lihat onboarding tapi belum login -> ke halaman login
                else -> {
                    startActivity(Intent(this, AuthActivity::class.java))
                }
            }
            finish()
        }, 2000)
    }
}