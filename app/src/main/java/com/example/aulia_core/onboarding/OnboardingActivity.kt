package com.example.aulia_core.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aulia_core.R
import com.example.aulia_core.databinding.ActivityOnboardingBinding

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(
            Onboarding1Fragment(),
            Onboarding2Fragment(),
            Onboarding3Fragment()
        )

        val adapter = OnboardingFragmentAdapter(this, fragments)
        binding.onboardingViewPager.adapter = adapter

        binding.dotIndicator.attachTo(binding.onboardingViewPager)
    }
}