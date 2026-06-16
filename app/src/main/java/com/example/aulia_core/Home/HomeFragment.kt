package com.example.aulia_core.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aulia_core.AuthActivity
import com.example.aulia_core.Home.berita.BeritaAdapter
import com.example.aulia_core.Home.pertemuan10.TenthActivity
import com.example.aulia_core.Home.pertemuan2.SecondActivity
import com.example.aulia_core.Home.pertemuan4.BlueMotivationActivity
import com.example.aulia_core.Home.pertemuan4.DailyGlowActivity
import com.example.aulia_core.Home.pertemuan5.WebViewActivity
import com.example.aulia_core.Home.pertemuan7.SeventhActivity
import com.example.aulia_core.Home.pertemuan9.NinthActivity
import com.example.aulia_core.data.api.CatFactApiClient
import com.example.aulia_core.data.model.Article
import com.example.aulia_core.data.model.Source
import com.example.aulia_core.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

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

        setupButtons()
        loadCatFact()
        loadBerita()

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }
    }

    private fun setupButtons() {
        binding.btnBangunRuang.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnRumus.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnDailyGlow.setOnClickListener {
            startActivity(Intent(requireContext(), DailyGlowActivity::class.java))
        }

        binding.btnMotivation.setOnClickListener {
            startActivity(Intent(requireContext(), BlueMotivationActivity::class.java))
        }

        binding.btnBinaDesa.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        binding.btnPertemuan7.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        binding.btnPertemuan9.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        // ========== TOMBOL PERTEMUAN 10 (LAYANAN DIGITAL + ROOM DATABASE) ==========
        binding.btnPertemuan10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin keluar dari Aulia Core?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    sharedPref.edit().clear().apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing: ${e.message}"
            }
        }
    }

    private fun loadBerita() {
        binding.progressBar.visibility = View.VISIBLE

        val mockArticles = listOf(
            Article(
                source = Source(null, "Kompas.com"),
                author = "Kompas.com",
                title = "Pembangunan Infrastruktur Desa Terus Digenjot Pemerintah",
                description = "Pemerintah terus mendorong pembangunan infrastruktur di desa-desa seluruh Indonesia untuk meningkatkan konektivitas dan ekonomi masyarakat.",
                url = "https://www.kompas.com",
                urlToImage = "https://picsum.photos/id/100/200/150",
                publishedAt = "2024-06-08T10:00:00Z",
                content = null
            ),
            Article(
                source = Source(null, "CNN Indonesia"),
                author = "CNN Indonesia",
                title = "Program Bina Desa Sukses Tingkatkan Ekonomi Masyarakat",
                description = "Program Bina Desa yang digalakkan sejak tahun lalu berhasil meningkatkan pendapatan masyarakat desa hingga 30 persen.",
                url = "https://www.cnnindonesia.com",
                urlToImage = "https://picsum.photos/id/101/200/150",
                publishedAt = "2024-06-07T15:30:00Z",
                content = null
            ),
            Article(
                source = Source(null, "Tribun News"),
                author = "Tribun News",
                title = "Digitalisasi Layanan Desa Dimulai Tahun Ini",
                description = "Seratus desa di Indonesia terpilih menjadi pilot project digitalisasi layanan administrasi desa berbasis aplikasi.",
                url = "https://www.tribunnews.com",
                urlToImage = "https://picsum.photos/id/102/200/150",
                publishedAt = "2024-06-06T09:00:00Z",
                content = null
            ),
            Article(
                source = Source(null, "Detik.com"),
                author = "Detik.com",
                title = "Pelatihan UMKM Desa Digelar Serentak di 50 Kabupaten",
                description = "Pemerintah menggandeng platform digital untuk memberikan pelatihan pemasaran online bagi pelaku UMKM desa.",
                url = "https://www.detik.com",
                urlToImage = "https://picsum.photos/id/103/200/150",
                publishedAt = "2024-06-05T14:00:00Z",
                content = null
            ),
            Article(
                source = Source(null, "Liputan6"),
                author = "Liputan6",
                title = "Wisata Desa Mulai Dilirik Wisatawan Mancanegara",
                description = "Potensi wisata desa mulai mendapat perhatian setelah program homestay desa diluncurkan oleh Kementerian Pariwisata.",
                url = "https://www.liputan6.com",
                urlToImage = "https://picsum.photos/id/104/200/150",
                publishedAt = "2024-06-04T11:00:00Z",
                content = null
            ),
            Article(
                source = Source(null, "Republika"),
                author = "Republika",
                title = "BUMDes Diminta Lebih Inovatif Kelola Potensi Desa",
                description = "Badan Usaha Milik Desa (BUMDes) diharapkan lebih inovatif dalam mengelola potensi desa untuk kemandirian ekonomi.",
                url = "https://www.republika.co.id",
                urlToImage = "https://picsum.photos/id/105/200/150",
                publishedAt = "2024-06-03T08:00:00Z",
                content = null
            )
        )

        val adapter = BeritaAdapter(mockArticles)
        binding.rvBerita.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBerita.adapter = adapter

        binding.progressBar.visibility = View.GONE
        Toast.makeText(requireContext(), "Berhasil memuat ${mockArticles.size} berita", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}