package com.example.aulia_core.Layanan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.aulia_core.databinding.FragmentLayananBinding

class LayananFragment : Fragment() {

    private var _binding: FragmentLayananBinding? = null
    private val binding get() = _binding!!

    // Data dengan gambar URL
    private val layananItems = listOf(
        LayananModel("https://avatar.iran.liara.run/public/1", "📱 Aplikasi Mobile", "Platform belajar digital Aulia Core"),
        LayananModel("https://avatar.iran.liara.run/public/2", "🌐 Web Bina Desa", "Portal informasi dan layanan desa"),
        LayananModel("https://avatar.iran.liara.run/public/3", "📚 Materi Pembelajaran", "Kumpulan modul dan materi belajar"),
        LayananModel("https://avatar.iran.liara.run/public/4", "💡 Tips & Trik", "Panduan penggunaan aplikasi"),
        LayananModel("https://avatar.iran.liara.run/public/5", "🆘 Bantuan", "Pusat bantuan dan FAQ"),
        LayananModel("https://avatar.iran.liara.run/public/6", "ℹ️ Tentang Aplikasi", "Informasi Aulia Core v1.0"),
        LayananModel("https://avatar.iran.liara.run/public/7", "⚙️ Pengaturan", "Atur preferensi aplikasi"),
        LayananModel("https://avatar.iran.liara.run/public/8", "📞 Kontak Kami", "Hubungi tim pengembang"),
        LayananModel("https://avatar.iran.liara.run/public/9", "🏠 Layanan Desa", "Pengurusan surat menyurat desa"),
        LayananModel("https://avatar.iran.liara.run/public/10", "👥 Data Penduduk", "Informasi kependudukan desa"),
        LayananModel("https://avatar.iran.liara.run/public/11", "📊 Laporan Keuangan", "Laporan APBDes dan keuangan desa"),
        LayananModel("https://avatar.iran.liara.run/public/12", "📢 Pengumuman Resmi", "Informasi resmi dari pemerintah desa"),
        LayananModel("https://avatar.iran.liara.run/public/13", "🔔 Notifikasi", "Pengaturan notifikasi aplikasi"),
        LayananModel("https://avatar.iran.liara.run/public/14", "🌙 Mode Gelap", "Tampilan gelap untuk kenyamanan mata"),
        LayananModel("https://avatar.iran.liara.run/public/15", "🔒 Privasi & Keamanan", "Kebijakan privasi aplikasi")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLayananBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Layanan Aulia Core"
        }

        val adapter = LayananAdapter(requireContext(), layananItems)
        binding.listViewItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}