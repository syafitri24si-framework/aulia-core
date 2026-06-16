package com.example.aulia_core.Home.pertemuan10

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aulia_core.databinding.FragmentTabLayananDigitalBinding

class TabLayananDigitalFragment : Fragment() {

    private var _binding: FragmentTabLayananDigitalBinding? = null
    private val binding get() = _binding!!

    private val layananList = listOf(
        LayananDigitalModel("Pembuatan KTP", "Layanan pembuatan Kartu Tanda Penduduk elektronik", "https://picsum.photos/id/20/400/300"),
        LayananDigitalModel("Pembuatan KK", "Layanan pembuatan Kartu Keluarga", "https://picsum.photos/id/24/400/300"),
        LayananDigitalModel("Surat Domisili", "Surat keterangan tempat tinggal", "https://picsum.photos/id/26/400/300"),
        LayananDigitalModel("Surat Keterangan Usaha", "Surat untuk izin usaha", "https://picsum.photos/id/29/400/300"),
        LayananDigitalModel("Akta Kelahiran", "Pencatatan kelahiran penduduk", "https://picsum.photos/id/30/400/300"),
        LayananDigitalModel("Surat Pindah", "Surat keterangan pindah penduduk", "https://picsum.photos/id/33/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabLayananDigitalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LayananDigitalAdapter(layananList) { selectedItem ->
            // BUKA FORM PENGAJUAN
            val intent = Intent(requireContext(), FormPengajuanLayananActivity::class.java)
            intent.putExtra("NAMA_LAYANAN", selectedItem.name)
            startActivity(intent)
        }

        binding.rvLayananDigital.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}