package com.mobven.fitai.presentation.onboarding.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.presentation.base.BaseFragment
import com.mobven.fitai.databinding.FragmentThirdOnBoardingBinding

class ThirdOnboardingFragment : BaseFragment<FragmentThirdOnBoardingBinding>(FragmentThirdOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding3Continue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager).setCurrentItem(nextItem, true)
        }
    }

}