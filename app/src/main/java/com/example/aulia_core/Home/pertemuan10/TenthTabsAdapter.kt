package com.example.aulia_core.Home.pertemuan10

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TenthTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4  // ← UBAH DARI 3 JADI 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabLayananFragment()
            1 -> TabInformasiFragment()
            2 -> TabLayananDigitalFragment()
            3 -> TabStatusPengajuanFragment()  // ← TAMBAHKAN INI
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}