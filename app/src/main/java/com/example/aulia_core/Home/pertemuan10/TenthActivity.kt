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

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Bina Desa"
        binding.toolbar.setNavigationOnClickListener { finish() }

        val tabsAdapter = TenthTabsAdapter(this)
        binding.viewPager.adapter = tabsAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Layanan Desa"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_surat)
                }
                1 -> {
                    tab.text = "Informasi Desa"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_info)
                }
                2 -> {
                    tab.text = "Layanan Digital"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_dashboard)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 6
                }
                3 -> {
                    tab.text = "Status"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_report)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
            }
        }.attach()

        // ========== CEK INTENT UNTUK LANGSUNG KE TAB STATUS ==========
        val openTab = intent.getIntExtra("OPEN_TAB", 0)
        if (openTab == 3) {
            binding.viewPager.currentItem = 3  // Langsung ke tab Status (index ke-3)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}