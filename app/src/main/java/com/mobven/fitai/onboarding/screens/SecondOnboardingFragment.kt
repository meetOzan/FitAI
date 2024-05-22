package com.mobven.fitai.onboarding.screens

import androidx.viewpager2.widget.ViewPager2
import com.mobven.fitai.R
import com.mobven.fitai.base.BaseFragment
import com.mobven.fitai.databinding.FragmentSecondOnBoardingBinding

class SecondOnboardingFragment : BaseFragment<FragmentSecondOnBoardingBinding>(FragmentSecondOnBoardingBinding::inflate) {

    override fun observeUi() {
        binding.btnOnboarding2Continue.setOnClickListener {
            val currentItem = requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager).currentItem
            val nextItem = currentItem + 1
            requireActivity().findViewById<ViewPager2>(R.id.onboardingViewPager).setCurrentItem(nextItem, true)
        }
    }

}