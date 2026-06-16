package com.example.aulia_core.Home.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aulia_core.data.database.AppDatabase
import com.example.aulia_core.data.entity.PengajuanLayananEntity
import com.example.aulia_core.databinding.FragmentTabStatusPengajuanBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TabStatusPengajuanFragment : Fragment() {
    private var _binding: FragmentTabStatusPengajuanBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private lateinit var adapter: PengajuanLayananAdapter
    private var pengajuanList = mutableListOf<PengajuanLayananEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabStatusPengajuanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())

        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        adapter = PengajuanLayananAdapter(pengajuanList) { pengajuan ->
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle("Hapus Pengajuan")
                .setMessage("Apakah kamu yakin ingin menghapus pengajuan ${pengajuan.namaLayanan}?")
                .setPositiveButton("Ya") { _, _ ->
                    lifecycleScope.launch {
                        db.pengajuanLayananDao().delete(pengajuan)
                        loadData()
                    }
                }
                .setNegativeButton("Batal", null)
                .show()
        }
        binding.rvStatus.layoutManager = LinearLayoutManager(requireContext())
        binding.rvStatus.adapter = adapter
    }

    private fun loadData() {
        lifecycleScope.launch {
            db.pengajuanLayananDao().getAll().collectLatest { data ->
                pengajuanList.clear()
                pengajuanList.addAll(data)
                adapter.notifyDataSetChanged()

                if (data.isEmpty()) {
                    binding.tvEmpty.visibility = View.VISIBLE
                    binding.rvStatus.visibility = View.GONE
                } else {
                    binding.tvEmpty.visibility = View.GONE
                    binding.rvStatus.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}