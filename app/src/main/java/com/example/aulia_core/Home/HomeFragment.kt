package com.example.aulia_core.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.aulia_core.AuthActivity
import com.example.aulia_core.Home.pertemuan2.SecondActivity
import com.example.aulia_core.Home.pertemuan4.BlueMotivationActivity
import com.example.aulia_core.Home.pertemuan4.DailyGlowActivity
import com.example.aulia_core.Home.pertemuan5.WebViewActivity
import com.example.aulia_core.Home.pertemuan7.SeventhActivity
import com.example.aulia_core.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Button 1: Hitung Bangun Ruang (P2)
        binding.btnBangunRuang.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        // Button 2: Rumus Bangun Ruang (dari WelcomeActivity)
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        // Button 3: Daily Glow (P4)
        binding.btnDailyGlow.setOnClickListener {
            startActivity(Intent(requireContext(), DailyGlowActivity::class.java))
        }

        // Button 4: Blue Motivation (P4)
        binding.btnMotivation.setOnClickListener {
            startActivity(Intent(requireContext(), BlueMotivationActivity::class.java))
        }

        // Button 5: Bina Desa (WebView)
        binding.btnBinaDesa.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Button 6: Fragment (P7)
        binding.btnPertemuan7.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    sharedPref.edit().clear().apply()
                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}