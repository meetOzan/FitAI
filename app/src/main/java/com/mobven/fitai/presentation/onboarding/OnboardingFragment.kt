package com.mobven.fitai.presentation.onboarding

import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentOnBoardingBinding

class OnboardingFragment : BaseFragment<FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.onboardingViewPager.adapter = OnboardingPagerAdapter(requireActivity())
        binding.onboardingDotsIndicator.attachTo(binding.onboardingViewPager)
    }

}