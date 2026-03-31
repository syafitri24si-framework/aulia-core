package com.example.aulia_core.pertemuan_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Inisialisasi Komponen
        val inputPanjang = findViewById<EditText>(R.id.inputPanjang)
        val inputLebar = findViewById<EditText>(R.id.inputLebar)
        val inputTinggi = findViewById<EditText>(R.id.inputTinggi)
        val btnLuas = findViewById<Button>(R.id.btnLuas)
        val btnVolume = findViewById<Button>(R.id.btnVolume)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // Logika Hitung Luas (Panjang x Lebar)
        btnLuas.setOnClickListener {
            val p = inputPanjang.text.toString().toDoubleOrNull()  ?: 0.0
            val l = inputLebar.text.toString().toDoubleOrNull()  ?: 0.0
            val hasil = p * l
            tvHasil.text = "Luas: $hasil"
        }

        // Logika Hitung Volume (Panjang x Lebar x Tinggi)
        btnVolume.setOnClickListener {
            val p = inputPanjang.text.toString().toDoubleOrNull() ?: 0.0
            val l = inputLebar.text.toString().toDoubleOrNull() ?: 0.0
            val t = inputTinggi.text.toString().toDoubleOrNull() ?: 0.0
            val hasil = p * l * t
            tvHasil.text = "Volume: $hasil"
        }
    }
}