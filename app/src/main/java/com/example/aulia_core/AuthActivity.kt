package com.example.aulia_core

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        findViewById<Button>(R.id.btnMasuk).setOnClickListener {
            startActivity(Intent(this, com.example.aulia_core.pertemuan3.LoginActivity::class.java))
        }
    }
}