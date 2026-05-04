package com.example.aulia_core.Profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aulia_core.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Instagram
        binding.ivInstagram.setOnClickListener {
            openUrl("https://www.instagram.com/frszakiaa_?igsh=d3cwMXA5c3F4NHly")
        }

        // GitHub
        binding.ivGithub.setOnClickListener {
            openUrl("https://github.com/faraspcr/far-app.git")
        }

        // LinkedIn
        binding.ivLinkedin.setOnClickListener {
            openUrl("https://www.linkedin.com/in/faras-zakia-indrani-29b4a6360/")
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}