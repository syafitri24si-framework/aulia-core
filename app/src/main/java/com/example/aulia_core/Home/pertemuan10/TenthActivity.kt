package com.example.aulia_core.Home.pertemuan10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.aulia_core.R
import com.example.aulia_core.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar dengan tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Bina Desa"
        binding.toolbar.setNavigationOnClickListener { finish() }

        // 1. Inisialisasi Adapter
        val tabsAdapter = TenthTabsAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Layanan Desa"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_surat)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Informasi Desa"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_info)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 3
                }
                2 -> {
                    tab.text = "Layanan Digital"  // ← GANTI
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_dashboard)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 20
                }
            }
        }.attach()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}