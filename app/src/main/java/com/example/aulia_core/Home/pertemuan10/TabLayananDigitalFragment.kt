package com.example.aulia_core.Home.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aulia_core.databinding.FragmentTabLayananDigitalBinding

class TabLayananDigitalFragment : Fragment() {

    private var _binding: FragmentTabLayananDigitalBinding? = null
    private val binding get() = _binding!!

    // Data Layanan Digital Bina Desa dengan GAMBAR DARI URL
    private val layananList = listOf(
        LayananDigitalModel("Pembuatan KTP", "Layanan pembuatan Kartu Tanda Penduduk elektronik", "https://picsum.photos/id/20/400/300"),
        LayananDigitalModel("Pembuatan KK", "Layanan pembuatan Kartu Keluarga", "https://picsum.photos/id/24/400/300"),
        LayananDigitalModel("Surat Domisili", "Surat keterangan tempat tinggal", "https://picsum.photos/id/26/400/300"),
        LayananDigitalModel("Surat Keterangan Usaha", "Surat untuk izin usaha", "https://picsum.photos/id/29/400/300"),
        LayananDigitalModel("Akta Kelahiran", "Pencatatan kelahiran penduduk", "https://picsum.photos/id/30/400/300"),
        LayananDigitalModel("Surat Pindah", "Surat keterangan pindah penduduk", "https://picsum.photos/id/33/400/300"),
        LayananDigitalModel("Surat Kematian", "Surat keterangan kematian", "https://picsum.photos/id/42/400/300"),
        LayananDigitalModel("SKTM", "Surat Keterangan Tidak Mampu", "https://picsum.photos/id/43/400/300"),
        LayananDigitalModel("IMB", "Izin Mendirikan Bangunan", "https://picsum.photos/id/47/400/300"),
        LayananDigitalModel("Surat Nikah", "Pencatatan pernikahan", "https://picsum.photos/id/48/400/300"),
        LayananDigitalModel("SKCK", "Surat Keterangan Catatan Kepolisian", "https://picsum.photos/id/58/400/300"),
        LayananDigitalModel("Surat Waris", "Surat keterangan ahli waris", "https://picsum.photos/id/60/400/300"),
        LayananDigitalModel("KIA", "Kartu Identitas Anak", "https://picsum.photos/id/62/400/300"),
        LayananDigitalModel("Surat Tanah", "Surat keterangan tanah", "https://picsum.photos/id/64/400/300"),
        LayananDigitalModel("Layanan Pengaduan", "Saluran aspirasi masyarakat", "https://picsum.photos/id/66/400/300"),
        LayananDigitalModel("Informasi Publik", "Layanan informasi desa", "https://picsum.photos/id/68/400/300"),
        LayananDigitalModel("Konsultasi Online", "Chat dengan perangkat desa", "https://picsum.photos/id/70/400/300"),
        LayananDigitalModel("Jadwal Posyandu", "Informasi jadwal posyandu", "https://picsum.photos/id/72/400/300"),
        LayananDigitalModel("Bantuan Sosial", "Bantuan sosial desa", "https://picsum.photos/id/74/400/300"),
        LayananDigitalModel("Layanan Kesehatan", "Rujukan kesehatan", "https://picsum.photos/id/76/400/300"),
        LayananDigitalModel("Vaksinasi", "Layanan vaksinasi desa", "https://picsum.photos/id/78/400/300"),
        LayananDigitalModel("Pelatihan UMKM", "Pelatihan usaha desa", "https://picsum.photos/id/80/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabLayananDigitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LayananDigitalAdapter(layananList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "📋 ${selectedItem.name}\n📝 ${selectedItem.description}",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.rvLayananDigital.apply {
            layoutManager = GridLayoutManager(requireContext(), 2) // 2 kolom
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}