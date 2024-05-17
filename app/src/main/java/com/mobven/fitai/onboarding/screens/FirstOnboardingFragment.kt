package com.mobven.fitai.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobven.fitai.databinding.FragmentFirstOnBoardingBinding
import com.mobven.fitai.onboarding.OnboardingPagerAdapter

class FirstOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentFirstOnBoardingBinding
    private val onboardingPagerAdapter by lazy { OnboardingPagerAdapter(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOnboarding1Continue.setOnClickListener {
            onboardingPagerAdapter.increaseCurrentItem()
        }

    }

}