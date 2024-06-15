package com.mobven.fitai.presentation.onboarding

import android.os.Bundle
import com.mobven.fitai.R
import com.mobven.fitai.common.SharedPreferencesHelper
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentOnBoardingBinding
import com.mobven.fitai.presentation.onboarding.adapter.OnboardingPagerAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnboardingFragment :
    BaseFragment<FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPreferencesHelper.getIsFirstLaunch(requireContext()).let {
            if (it == true) {
                val action = OnboardingFragmentDirections.actionOnboardingFragmentToAuthFragment()
                navigate(action)
            }
        }
    }

    override fun observeUi() {
        binding.onboardingViewPager.adapter = OnboardingPagerAdapter(requireActivity())
        binding.onboardingDotsIndicator.attachTo(binding.onboardingViewPager)
    }

}