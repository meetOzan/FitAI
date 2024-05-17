package com.mobven.fitai.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentSecondOnBoardingBinding
import com.mobven.fitai.onboarding.OnboardingPagerAdapter

class SecondOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentSecondOnBoardingBinding
    private val onboardingPagerAdapter by lazy { OnboardingPagerAdapter(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOnboarding2Continue.setOnClickListener {
            onboardingPagerAdapter.increaseCurrentItem()
        }

    }

}