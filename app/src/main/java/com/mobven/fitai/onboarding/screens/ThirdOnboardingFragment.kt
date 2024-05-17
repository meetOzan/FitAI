package com.mobven.fitai.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.R
import com.mobven.fitai.databinding.FragmentThirdOnBoardingBinding
import com.mobven.fitai.onboarding.OnboardingPagerAdapter


class ThirdOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentThirdOnBoardingBinding
    private val onboardingPagerAdapter by lazy { OnboardingPagerAdapter(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOnboarding3Continue.setOnClickListener {
            onboardingPagerAdapter.increaseCurrentItem()
        }
    }

}